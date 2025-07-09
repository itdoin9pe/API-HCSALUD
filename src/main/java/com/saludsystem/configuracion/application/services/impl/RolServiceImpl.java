package com.saludsystem.configuracion.application.services.impl;

import com.saludsystem.configuracion.application.dto.get.RolDTO;
import com.saludsystem.configuracion.application.dto.post.CrearRolDTO;
import com.saludsystem.configuracion.application.dto.put.ActualizarRolDTO;
import com.saludsystem.configuracion.application.services.RolService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.RoleEntity;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.RoleRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.UserRepository;
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
public class RolServiceImpl implements RolService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public RolServiceImpl(RoleRepository roleRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveRole(CrearRolDTO crearRolDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        RoleEntity role = new RoleEntity();
        role.setNombre(crearRolDTO.getNombre());
        role.setEstado(crearRolDTO.getEstado());
        role.setHospital(hospital);
        roleRepository.save(role);
        return new ApiResponse(true, "Role creado correctamente");
    }

    @Override
    public List<RolDTO> getRoleList() {
        return roleRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    @Override
    public ListResponse<RolDTO> getAllRole(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<RoleEntity> rolePage = roleRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<RolDTO> data = rolePage.getContent().stream().map(this::convertToDTO).toList();
        return new ListResponse<>(data, rolePage.getTotalElements(), rolePage.getTotalPages(), rolePage.getNumber() + 1);
    }

    @Override
    public RolDTO getRoleById(UUID roleId) {
        RoleEntity role = roleRepository.findById(roleId).
                orElseThrow( () -> new ResourceNotFoundException("Role no encontrado"));
        RolDTO dto = new RolDTO();
        dto.setRoleId(role.getRoleId());
        dto.setNombre(role.getNombre());
        dto.setEstado(role.getEstado());
        return dto;
    }

    @Override
    public ApiResponse updateRole(UUID roleId, ActualizarRolDTO actualizarRolDTO) {
        RoleEntity role = roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        Optional.ofNullable(actualizarRolDTO.getNombre()).ifPresent(role::setNombre);
        Optional.ofNullable(actualizarRolDTO.getEstado()).ifPresent(role::setEstado);
        roleRepository.save(role);
        return new ApiResponse(true, "Role actualizado correctamente");
    }

    @Override
    public ApiResponse deleteRole(UUID roleId) {
        roleRepository.deleteById(roleId);
        return new ApiResponse(true, "Role eliminado correctamente");
    }

    private RolDTO convertToDTO(RoleEntity role) {
        return modelMapper.map(role, RolDTO.class);
    }
}