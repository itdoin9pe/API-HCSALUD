package com.saludsystem.application.services.paciente.impl;

import com.saludsystem.application.dtos.paciente.get.EstudioResultadoDTO;
import com.saludsystem.application.dtos.paciente.post.CrearEstudioResultadoDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarEstudioResultadoDTO;
import com.saludsystem.application.services.paciente.EstudioResultadoService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.configuracion.SysSaludEntity;
import com.saludsystem.domain.model.configuracion.UserEntity;
import com.saludsystem.domain.model.paciente.EstudioResultadoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.SysSaludRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.UserRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstudioMedicoRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstudioResultadoRepository;
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
    public ApiResponse saveEstudioResultado(CrearEstudioResultadoDTO crearEstudioResultadoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        EstudioResultadoEntity estudioResultadoEntity = new EstudioResultadoEntity();
        estudioResultadoEntity.setEstudioMedicoEntity(estudioMedicoRepository.findById(crearEstudioResultadoDTO.getPacienteEstudioMedicoId()).
                orElseThrow( () -> new ResourceNotFoundException("Estudio medico no encontrado") ));
        estudioResultadoEntity.setReporteTexto(crearEstudioResultadoDTO.getReporteTexto());
        estudioResultadoEntity.setUrlImg(crearEstudioResultadoDTO.getUrlImg());
        estudioResultadoEntity.setCreatedAt(crearEstudioResultadoDTO.getCreatedAt());
        estudioResultadoEntity.setHospital(hospital);
        estudioResultadoEntity.setUser(userEntity);
        estudioResultadoRepository.save(estudioResultadoEntity);
        return new ApiResponse(true, "Resultado de estudio creado correctamente");
    }

    @Override
    public ListResponse<EstudioResultadoDTO> getAllEstudioResultado(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EstudioResultadoEntity> estudioResultadoEntityPage = estudioResultadoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EstudioResultadoDTO> data = estudioResultadoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
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
    public EstudioResultadoDTO getEstudioResultadoById(Long pacienteEstudioResultadoId) {
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

    private EstudioResultadoDTO convertToDTO(EstudioResultadoEntity estudioResultadoEntity) {
        return modelMapper.map(estudioResultadoEntity, EstudioResultadoDTO.class);
    }

}