package com.saludsystem.paciente.application.service.impl.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.get.historialclinico.evolucion.EvolucionDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.evolucion.CrearEvolucionDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.evolucion.ActualizarEvolucionDTO;
import com.saludsystem.paciente.application.service.historialclinico.evolucion.EvolucionService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.evolucion.EvolucionEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.evolucion.EvolucionRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EvolucionServiceImpl implements EvolucionService {

    private final EvolucionRepository evolucionRepository;
    private final SysSaludRepository sysSaludRepository;
    private final AuthValidator authValidator;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public EvolucionServiceImpl(EvolucionRepository evolucionRepository, SysSaludRepository sysSaludRepository, AuthValidator authValidator, PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.evolucionRepository = evolucionRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.authValidator = authValidator;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveEvolucion(CrearEvolucionDTO crearEvolucionDTO) {
        authValidator.validateAdminAccess();
        var user = authValidator.getCurrentUser();
        var hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        var evolucionEntity = new EvolucionEntity();
        evolucionRepository.save(evolucionEntity);
        evolucionEntity.setPacienteEntity(pacienteRepository.findById(crearEvolucionDTO.getPacienteId()).
                orElseThrow(() -> new ResourceNotFoundException("Paciente not found")));
        evolucionEntity.setFechaInicio(crearEvolucionDTO.getFechaInicio());
        evolucionEntity.setFinalizada(crearEvolucionDTO.getFinalizada());
        evolucionEntity.setHospital(hospital);
        evolucionEntity.setUser(user);
        evolucionRepository.save(evolucionEntity);
        return new ApiResponse(true, "Evolucion creada correctamente");
    }

    @Override
    public ListResponse<EvolucionDTO> getAllEvolucion(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EvolucionEntity> evolucionEntityPage = evolucionRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EvolucionDTO> data = evolucionEntityPage.getContent().stream().map(this::convertToDTO).toList();
        return new ListResponse<>(data, evolucionEntityPage.getTotalElements(), evolucionEntityPage.getTotalPages(), evolucionEntityPage.getNumber() + 1);
    }

    @Override
    public EvolucionDTO getEvolucionById(UUID pacienteEvolucionId) {
        EvolucionEntity evolucionEntity = evolucionRepository.findById(pacienteEvolucionId).orElseThrow(
                () -> new ResourceNotFoundException("Evolucion no encontrada"));
        return convertToDTO(evolucionEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateEvolucion(UUID pacienteEvolucionId, ActualizarEvolucionDTO actualizarEvolucionDTO) {
        authValidator.validateAdminAccess();
        EvolucionEntity evolucionEntity = evolucionRepository.findById(pacienteEvolucionId).orElseThrow(
                () -> new ResourceNotFoundException("Evolucion no encontrada"));
        Optional.ofNullable(actualizarEvolucionDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(evolucionEntity::setPacienteEntity);
        Optional.ofNullable(actualizarEvolucionDTO.getFechaInicio()).ifPresent(evolucionEntity::setFechaInicio);
        Optional.ofNullable(actualizarEvolucionDTO.getFinalizada()).ifPresent(evolucionEntity::setFinalizada);
        evolucionRepository.save(evolucionEntity);
        return new ApiResponse(true, "Evolucion actualizada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteEvolucion(UUID pacienteEvolucionId) {
        authValidator.validateAdminAccess();
        evolucionRepository.deleteById(pacienteEvolucionId);
        return new ApiResponse(true, "Evolucion eliminada correctamente");
    }

    private EvolucionDTO convertToDTO(EvolucionEntity evolucionEntity) {
        return modelMapper.map(evolucionEntity, EvolucionDTO.class);
    }
}