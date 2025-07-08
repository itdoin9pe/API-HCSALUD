package com.saludsystem.paciente.application.service.impl;

import com.saludsystem.paciente.application.dto.res.EstudioResultadoResponse;
import com.saludsystem.paciente.application.dto.req.EstudioResultadoRequest;
import com.saludsystem.paciente.application.dto.ActualizarEstudioResultadoDTO;
import com.saludsystem.paciente.application.service.EstudioResultadoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.paciente.domain.model.EstudioResultadoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.UserRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstudioMedicoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstudioResultadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EstudioResultadoServiceImpl implements EstudioResultadoService {

    private final EstudioResultadoRepository estudioResultadoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final EstudioMedicoRepository estudioMedicoRepository;
    private final ModelMapper modelMapper;

    public EstudioResultadoServiceImpl(EstudioResultadoRepository estudioResultadoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, EstudioMedicoRepository estudioMedicoRepository, ModelMapper modelMapper) {
        this.estudioResultadoRepository = estudioResultadoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.estudioMedicoRepository = estudioMedicoRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveEstudioResultado(EstudioResultadoRequest estudioResultadoRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        EstudioResultadoEntity estudioResultadoEntity = new EstudioResultadoEntity();
        estudioResultadoEntity.setEstudioMedicoEntity(estudioMedicoRepository.findById(estudioResultadoRequest.getPacienteEstudioMedicoId()).
                orElseThrow( () -> new ResourceNotFoundException("Estudio medico no encontrado") ));
        estudioResultadoEntity.setReporteTexto(estudioResultadoRequest.getReporteTexto());
        estudioResultadoEntity.setUrlImg(estudioResultadoRequest.getUrlImg());
        estudioResultadoEntity.setCreatedAt(estudioResultadoRequest.getCreatedAt());
        estudioResultadoEntity.setHospital(hospital);
        estudioResultadoEntity.setUser(userEntity);
        estudioResultadoRepository.save(estudioResultadoEntity);
        return new ApiResponse(true, "Resultado de estudio creado correctamente");
    }

    @Override
    public ListResponse<EstudioResultadoResponse> getAllEstudioResultado(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EstudioResultadoEntity> estudioResultadoEntityPage = estudioResultadoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EstudioResultadoResponse> data = estudioResultadoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, estudioResultadoEntityPage.getTotalElements(), estudioResultadoEntityPage.getTotalPages(), estudioResultadoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateEstudioResultado(Long pacienteEstudioResultadoId, ActualizarEstudioResultadoDTO actualizarEstudioResultadoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
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
    public EstudioResultadoResponse getEstudioResultadoById(Long pacienteEstudioResultadoId) {
        EstudioResultadoEntity estudioResultadoEntity = estudioResultadoRepository.findById(pacienteEstudioResultadoId).orElseThrow(
                () -> new ResourceNotFoundException("Resultado de estudio no encontrado"));
        return convertToDTO(estudioResultadoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteEstudioResultado(Long pacienteEstudioResultadoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        estudioResultadoRepository.deleteById(pacienteEstudioResultadoId);
        return new ApiResponse(true, "Resultado de estudio retirada correctamente");
    }

    private EstudioResultadoResponse convertToDTO(EstudioResultadoEntity estudioResultadoEntity) {
        return modelMapper.map(estudioResultadoEntity, EstudioResultadoResponse.class);
    }

}