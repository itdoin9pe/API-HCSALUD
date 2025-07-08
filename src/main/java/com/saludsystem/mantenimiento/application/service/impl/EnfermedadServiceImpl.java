package com.saludsystem.mantenimiento.application.service.impl;


import com.saludsystem.mantenimiento.application.dto.res.EnfermedadDTO;
import com.saludsystem.mantenimiento.application.dto.req.EnfermedadRequest;
import com.saludsystem.mantenimiento.application.dto.res.EnfermedadResponse;
import com.saludsystem.configuracion.application.services.AuthService;
import com.saludsystem.configuracion.application.services.RolePrefixResolver;
import com.saludsystem.mantenimiento.application.service.EnfermedadService;
import com.saludsystem.configuracion.domain.model.RoleEntity;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.mantenimiento.domain.model.EnfermedadEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;

import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.UserRepository;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.EnfermedadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EnfermedadServiceImpl implements EnfermedadService {

    private final EnfermedadRepository enfermedadRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final RolePrefixResolver rolePrefixResolver;
    private final AuthService authService;
    private final ModelMapper modelMapper;

    public EnfermedadServiceImpl(EnfermedadRepository enfermedadRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, RolePrefixResolver rolePrefixResolver, AuthService authService, ModelMapper modelMapper) {
        this.enfermedadRepository = enfermedadRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.rolePrefixResolver = rolePrefixResolver;
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveEnfermedad(EnfermedadRequest enfermedadRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        EnfermedadEntity diagnosticoEntity = new EnfermedadEntity();
        diagnosticoEntity.setEnfermedadId(enfermedadRequest.getEnfermedadId());
        diagnosticoEntity.setDescripcion(enfermedadRequest.getDescripcion());
        diagnosticoEntity.setEstado(enfermedadRequest.getEstado());
        diagnosticoEntity.setUser(userEntity);
        diagnosticoEntity.setHospital(hospital);
        enfermedadRepository.save(diagnosticoEntity);
        return new ApiResponse(true, "Diagnostico registrado correctamente");
    }

    @Override
    public List<EnfermedadDTO> getEnfermedadList() {
        return enfermedadRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<EnfermedadDTO> getAllEnfermedad(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EnfermedadEntity> diagnosticoModelPage = enfermedadRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EnfermedadDTO> data = diagnosticoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, diagnosticoModelPage.getTotalElements(), diagnosticoModelPage.getTotalPages(), diagnosticoModelPage.getNumber() +1 );
    }

    @Override
    public ApiResponse updateEnfermedad(String enfermedadId, EnfermedadResponse enfermedadResponse) {
        EnfermedadEntity diagnosticoEntity = enfermedadRepository.findById(enfermedadId).orElseThrow( () -> new ResourceNotFoundException("Diagnostico no encontrado"));
        Optional.ofNullable(enfermedadResponse.getEnfermedadId()).filter(desc -> !desc.isBlank()).ifPresent(diagnosticoEntity::setEnfermedadId);
        Optional.ofNullable(enfermedadResponse.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(diagnosticoEntity::setDescripcion);
        Optional.ofNullable(enfermedadResponse.getEstado()).ifPresent(diagnosticoEntity::setEstado);
        enfermedadRepository.save(diagnosticoEntity);
        return new ApiResponse(true, "Diagnostico registrado correctamente");
    }

    @Override
    public EnfermedadDTO getEnfermedadById(String enfermedadId) {
        EnfermedadEntity enfermedadEntity = enfermedadRepository.findById(enfermedadId).orElseThrow( () -> new ResourceNotFoundException("Diagnostico no encontrado"));
        return convertToDTO(enfermedadEntity);
    }

    @Override
    public ApiResponse deleteEnfermedad(String enfermedadId) {
        enfermedadRepository.deleteById(enfermedadId);
        return new ApiResponse(true, "Diagnostico eliminado correctamente");
    }

    // Impl filtrado por rol de especialidad
    @Override
    public List<EnfermedadDTO> getEnfermedadFiltradosPorRol() {
        UserEntity usuario = authService.getCurrentUser();
        RoleEntity rol = usuario.getRol();
        String prefix = rolePrefixResolver.resolvePrefixFromRole(rol);
        if (prefix == null) {
            return List.of();
        }
        List<EnfermedadEntity> enfernedades = enfermedadRepository.findByRolePrefixAndHospital(
                prefix + "-",
                usuario.getHospital().getHospitalId()
        );
        return enfernedades.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EnfermedadDTO convertToDTO(EnfermedadEntity diagnosticoEntity) {
        return modelMapper.map(diagnosticoEntity, EnfermedadDTO.class);
    }

}