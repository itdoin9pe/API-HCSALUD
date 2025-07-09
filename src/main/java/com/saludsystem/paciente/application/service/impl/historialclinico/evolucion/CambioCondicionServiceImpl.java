package com.saludsystem.paciente.application.service.impl.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.get.historialclinico.evolucion.CambioCondicionDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.evolucion.CrearCambioCondicionDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.evolucion.ActualizarCambioCondicionDTO;
import com.saludsystem.paciente.application.service.historialclinico.evolucion.CambioCondicionService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.Evolucion.CambioCondicionEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.evolucion.CambioCondicionRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.evolucion.EvolucionRepository;
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
import java.util.stream.Collectors;

@Service
public class CambioCondicionServiceImpl implements CambioCondicionService {

    private final CambioCondicionRepository cambioCondicionRepository;
    private final SysSaludRepository sysSaludRepository;
    private final EvolucionRepository evolucionRepository;
    private final AuthValidator authValidator;
    private final ModelMapper modelMapper;

    public CambioCondicionServiceImpl(CambioCondicionRepository cambioCondicionRepository, SysSaludRepository sysSaludRepository, EvolucionRepository evolucionRepository, AuthValidator authValidator, ModelMapper modelMapper) {
        this.cambioCondicionRepository = cambioCondicionRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.evolucionRepository = evolucionRepository;
        this.authValidator = authValidator;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("HasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveCambioCondicion(CrearCambioCondicionDTO crearCambioCondicionDTO) {
        authValidator.validateAdminAccess();
        var user = authValidator.getCurrentUser();
        var hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        var cambioCondicionEntity = new CambioCondicionEntity();
        cambioCondicionEntity.setEvolucionEntity(evolucionRepository.findById(crearCambioCondicionDTO.getPacienteEvolucionId())
                .orElseThrow( () -> new ResourceNotFoundException("Evolucion not found")));
        cambioCondicionEntity.setFecha(crearCambioCondicionDTO.getFecha());
        cambioCondicionEntity.setDescripcion(cambioCondicionEntity.getDescripcion());
        cambioCondicionEntity.setHospital(hospital);
        cambioCondicionEntity.setUser(user);
        cambioCondicionRepository.save(cambioCondicionEntity);
        return new ApiResponse(true, "Cambio de condicion guardada correctamente");
    }

    @Override
    public CambioCondicionDTO getCambioCondicionById(Long evolucionCambioCondicionId) {
        CambioCondicionEntity cambioCondicionEntity = cambioCondicionRepository.findById(evolucionCambioCondicionId).orElseThrow(
                () -> new ResourceNotFoundException("Cambio de condicion no encontrado"));
        return convertToDTO(cambioCondicionEntity);
    }

    @PreAuthorize("HasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateCambioCondicion(Long evolucionCambioCondicionId, ActualizarCambioCondicionDTO actualizarCambioCondicionDTO) {
        authValidator.validateAdminAccess();
        CambioCondicionEntity cambioCondicionEntity = cambioCondicionRepository.findById(evolucionCambioCondicionId).orElseThrow(
                () -> new ResourceNotFoundException("Cambio de condicion no encontrado"));
        Optional.ofNullable(actualizarCambioCondicionDTO.getPacienteEvolucionId())
                .flatMap(evolucionRepository::findById)
                .ifPresent(cambioCondicionEntity::setEvolucionEntity);
        Optional.ofNullable(actualizarCambioCondicionDTO.getFecha()).ifPresent(cambioCondicionEntity::setFecha);
        Optional.ofNullable(actualizarCambioCondicionDTO.getDescripcion()).ifPresent(cambioCondicionEntity::setDescripcion);
        return new ApiResponse(true, "Cambio de condicion actualizado correctamente");
    }

    @Override
    public ListResponse<CambioCondicionDTO> getAllCambioCondicion(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CambioCondicionEntity> cambioCondicionEntityPage = cambioCondicionRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CambioCondicionDTO> data = cambioCondicionEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, cambioCondicionEntityPage.getTotalElements(), cambioCondicionEntityPage.getTotalPages(), cambioCondicionEntityPage.getNumber() + 1);
    }

    @PreAuthorize("HasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteCambioCondicion(Long evolucionCambioCondicionId) {
        authValidator.validateAdminAccess();
        cambioCondicionRepository.deleteById(evolucionCambioCondicionId);
        return new ApiResponse(true, "Cambio de condicion eliminado correctamente");
    }

    private CambioCondicionDTO convertToDTO(CambioCondicionEntity cambioCondicionEntity) {
        return modelMapper.map(cambioCondicionEntity, CambioCondicionDTO.class);
    }
}