package com.saludsystem.paciente.application.service.impl;

import com.saludsystem.paciente.application.dto.get.EstudioResultadoDTO;
import com.saludsystem.paciente.application.dto.post.CrearEstudioResultadoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarEstudioResultadoDTO;
import com.saludsystem.paciente.application.service.EstudioResultadoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.EstudioResultadoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstudioMedicoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstudioResultadoRepository;
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
public class EstudioResultadoServiceImpl implements EstudioResultadoService {

    private final EstudioResultadoRepository estudioResultadoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final EstudioMedicoRepository estudioMedicoRepository;
    private final ModelMapper modelMapper;
    private final AuthValidator authValidator;

    public EstudioResultadoServiceImpl(EstudioResultadoRepository estudioResultadoRepository, SysSaludRepository sysSaludRepository, EstudioMedicoRepository estudioMedicoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        this.estudioResultadoRepository = estudioResultadoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.estudioMedicoRepository = estudioMedicoRepository;
        this.modelMapper = modelMapper;
        this.authValidator = authValidator;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveEstudioResultado(CrearEstudioResultadoDTO crearEstudioResultadoDTO) {
        authValidator.validateAdminAccess();
        var user = authValidator.getCurrentUser();
        var hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        EstudioResultadoEntity estudioResultadoEntity = new EstudioResultadoEntity();
        estudioResultadoEntity.setEstudioMedicoEntity(estudioMedicoRepository.findById(crearEstudioResultadoDTO.getPacienteEstudioMedicoId()).
                orElseThrow( () -> new ResourceNotFoundException("Estudio medico no encontrado") ));
        estudioResultadoEntity.setReporteTexto(crearEstudioResultadoDTO.getReporteTexto());
        estudioResultadoEntity.setUrlImg(crearEstudioResultadoDTO.getUrlImg());
        estudioResultadoEntity.setCreatedAt(crearEstudioResultadoDTO.getCreatedAt());
        estudioResultadoEntity.setHospital(hospital);
        estudioResultadoEntity.setUser(user);
        estudioResultadoRepository.save(estudioResultadoEntity);
        return new ApiResponse(true, "Resultado de estudio creado correctamente");
    }

    @Override
    public ListResponse<EstudioResultadoDTO> getAllEstudioResultado(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EstudioResultadoEntity> estudioResultadoEntityPage = estudioResultadoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EstudioResultadoDTO> data = estudioResultadoEntityPage.getContent().stream().map(this::convertToDTO).toList();
        return new ListResponse<>(data, estudioResultadoEntityPage.getTotalElements(), estudioResultadoEntityPage.getTotalPages(), estudioResultadoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateEstudioResultado(Long pacienteEstudioResultadoId, ActualizarEstudioResultadoDTO actualizarEstudioResultadoDTO) {
        authValidator.validateAdminAccess();
        EstudioResultadoEntity estudioResultadoEntity = estudioResultadoRepository.findById(pacienteEstudioResultadoId).orElseThrow(
                () -> new ResourceNotFoundException("Resultado de estudio no encontrado"));
        Optional.ofNullable(actualizarEstudioResultadoDTO.getPacienteEstudioMedicoId()).flatMap(estudioMedicoRepository::findById).ifPresent(estudioResultadoEntity::setEstudioMedicoEntity);
        Optional.ofNullable(actualizarEstudioResultadoDTO.getReporteTexto()).ifPresent(estudioResultadoEntity::setReporteTexto);
        Optional.ofNullable(actualizarEstudioResultadoDTO.getUrlImg()).ifPresent(estudioResultadoEntity::setUrlImg);
        Optional.ofNullable(actualizarEstudioResultadoDTO.getCreatedAt()).ifPresent(estudioResultadoEntity::setCreatedAt);
        estudioResultadoRepository.save(estudioResultadoEntity);
        return new ApiResponse(true, "resultado de estudio actualizado correctamente");
    }

    @Override
    public EstudioResultadoDTO getEstudioResultadoById(Long pacienteEstudioResultadoId) {
        EstudioResultadoEntity estudioResultadoEntity = estudioResultadoRepository.findById(pacienteEstudioResultadoId).orElseThrow(
                () -> new ResourceNotFoundException("Resultado de estudio no encontrado"));
        return convertToDTO(estudioResultadoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteEstudioResultado(Long pacienteEstudioResultadoId) {
        authValidator.validateAdminAccess();
        estudioResultadoRepository.deleteById(pacienteEstudioResultadoId);
        return new ApiResponse(true, "Resultado de estudio retirada correctamente");
    }

    private EstudioResultadoDTO convertToDTO(EstudioResultadoEntity estudioResultadoEntity) {
        return modelMapper.map(estudioResultadoEntity, EstudioResultadoDTO.class);
    }
}