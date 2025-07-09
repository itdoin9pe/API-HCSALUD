package com.saludsystem.paciente.application.service.impl.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.get.historialclinico.evolucion.AltaMedicaDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.evolucion.CrearAltaMedicaDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.evolucion.ActualizarAltaMedicaDTO;
import com.saludsystem.paciente.application.service.historialclinico.evolucion.AltaMedicaService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.evolucion.AltaMedicaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.evolucion.AltaMedicaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.evolucion.EvolucionRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import static com.saludsystem.shared.infrastructure.constants.ErrorMessage.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
                .orElseThrow(() -> new ResourceNotFoundException(CLINICA_NOT_FOUND));
        var altaMedicaEntity = new AltaMedicaEntity();
        altaMedicaEntity.setEvolucionEntity(evolucionRepository.findById(crearAltaMedicaDTO.getPacienteEvolucionId())
                .orElseThrow( () -> new ResourceNotFoundException(ALTA_MEDICA_NOT_FOUND)));
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
                () -> new ResourceNotFoundException(ALTA_MEDICA_NOT_FOUND));
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
        List<AltaMedicaDTO> data = altaMedicaEntityPage.getContent().stream().map(this::convertToDTO).toList();
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