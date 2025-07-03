package com.saludsystem.application.services.paciente.impl.Evolucion;

import com.saludsystem.application.dtos.paciente.get.evolucion.AltaMedicaDTO;
import com.saludsystem.application.dtos.paciente.post.evolucion.CrearAltaMedicaDTO;
import com.saludsystem.application.dtos.paciente.put.evolucion.ActualizarAltaMedicaDTO;
import com.saludsystem.application.services.paciente.Evolucion.AltaMedicaService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.Evolucion.AltaMedicaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.SysSaludRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Evolucion.AltaMedicaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Evolucion.EvolucionRepository;
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
public class AltaMedicaServiceImpl implements AltaMedicaService {

    private final AltaMedicaRepository altaMedicaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final EvolucionRepository evolucionRepository;
    private final AuthValidator authValidator;
    private final ModelMapper modelMapper;

    public AltaMedicaServiceImpl(AltaMedicaRepository altaMedicaRepository, SysSaludRepository sysSaludRepository, EvolucionRepository evolucionRepository, AuthValidator authValidator, ModelMapper modelMapper) {
        this.altaMedicaRepository = altaMedicaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.evolucionRepository = evolucionRepository;
        this.authValidator = authValidator;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveAltaMedica(CrearAltaMedicaDTO crearAltaMedicaDTO) {
        authValidator.validateAdminAccess();
        var user = authValidator.getCurrentUser();
        var hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        var altaMedicaEntity = new AltaMedicaEntity();
        altaMedicaEntity.setEvolucionEntity(evolucionRepository.findById(crearAltaMedicaDTO.getPacienteEvolucionId())
                .orElseThrow( () -> new RuntimeException("Alta medica no encontrada")));
        altaMedicaEntity.setFecha(crearAltaMedicaDTO.getFecha());
        altaMedicaEntity.setResumenFinal(crearAltaMedicaDTO.getResumenFinal());
        altaMedicaEntity.setHospital(hospital);
        altaMedicaEntity.setUser(user);
        altaMedicaRepository.save(altaMedicaEntity);
        return new ApiResponse(true, "Alta medica ingresada correctamente");
    }

    @Override
    public AltaMedicaDTO getAltaMedicaById(Long evolucionAltaMedicaId) {
        AltaMedicaEntity altaMedicaEntity = altaMedicaRepository.findById(evolucionAltaMedicaId).orElseThrow(
                () -> new ResourceNotFoundException("Alta medica no encontrada"));
        return convertToDTO(altaMedicaEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateAltaMedica(Long evolucionAltaMedicaId, ActualizarAltaMedicaDTO actualizarAltaMedicaDTO) {
        authValidator.validateAdminAccess();
        AltaMedicaEntity altaMedicaEntity = altaMedicaRepository.findById(evolucionAltaMedicaId).orElseThrow(
                () -> new ResourceNotFoundException("Alta medica no encontrada"));
        Optional.ofNullable(actualizarAltaMedicaDTO.getPacienteEvolucionId()).
                flatMap(evolucionRepository::findById).
                ifPresent(altaMedicaEntity::setEvolucionEntity);
        Optional.ofNullable(actualizarAltaMedicaDTO.getFecha()).ifPresent(altaMedicaEntity::setFecha);
        Optional.ofNullable(actualizarAltaMedicaDTO.getResumenFinal()).ifPresent(altaMedicaEntity::setResumenFinal);
        altaMedicaRepository.save(altaMedicaEntity);
        return new ApiResponse(true, "Alta medica modificada correctamente");
    }

    @Override
    public ListResponse<AltaMedicaDTO> getAllAltaMedica(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AltaMedicaEntity> altaMedicaEntityPage = altaMedicaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AltaMedicaDTO> data = altaMedicaEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data,
                altaMedicaEntityPage.getTotalElements(),
                altaMedicaEntityPage.getTotalPages(),
                altaMedicaEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteAltaMedica(Long evolucionAltaMedicaId) {
        authValidator.validateAdminAccess();
        altaMedicaRepository.deleteById(evolucionAltaMedicaId);
        return new ApiResponse(true, "Alta medica eliminada correctamente");
    }

    private AltaMedicaDTO convertToDTO(AltaMedicaEntity altaMedicaEntity) {
        return modelMapper.map(altaMedicaEntity, AltaMedicaDTO.class);
    }
}