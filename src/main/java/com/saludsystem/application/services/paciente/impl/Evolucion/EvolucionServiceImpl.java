package com.saludsystem.application.services.paciente.impl.Evolucion;

import com.saludsystem.application.dtos.paciente.get.evolucion.EvolucionDTO;
import com.saludsystem.application.dtos.paciente.post.evolucion.CrearEvolucionDTO;
import com.saludsystem.application.dtos.paciente.put.evolucion.ActualizarEvolucionDTO;
import com.saludsystem.application.services.paciente.Evolucion.EvolucionService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.Evolucion.EvolucionEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.SysSaludRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Evolucion.EvolucionRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        List<EvolucionDTO> data = evolucionEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
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