package com.saludSystem.services.modules.configuration.Rol.impl;

import com.saludSystem.dtos.configuration.Rol.ActualizarRolDTO;
import com.saludSystem.dtos.configuration.Rol.CrearRolDTO;
import com.saludSystem.dtos.configuration.Rol.RolDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.configuracion.Role;
import com.saludSystem.entities.User;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Configuration.UserRepository;
import com.saludSystem.repositories.modules.Configuration.RoleRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.services.modules.configuration.Rol.RolService;
import org.modelmapper.ModelMapper;
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
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        Role role = new Role();
        role.setNombre(crearRolDTO.getNombre());
        role.setEstado(crearRolDTO.getEstado());
        role.setHospital(hospital);
        roleRepository.save(role);
        return new ApiResponse(true, "Role creado correctamente");
    }

    @Override
    public List<RolDTO> getRoleList() {
        return roleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<RolDTO> getAllRole(UUID hospitalId, int page, int rows) {
        List<Role> roles = roleRepository.findByHospital_HospitalId(hospitalId);
        List<RolDTO> data = roles.stream().map(role ->  {
            RolDTO dto = new RolDTO();
            dto.setRoleId(role.getRoleId());
            dto.setNombre(role.getNombre());
            dto.setEstado(role.getEstado());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    @Override
    public RolDTO getRoleById(UUID roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow( () -> new ResourceNotFoundException("Role no encontrado"));
        RolDTO dto = new RolDTO();
        dto.setRoleId(role.getRoleId());
        dto.setNombre(role.getNombre());
        dto.setEstado(role.getEstado());
        return dto;
    }

    @Override
    public ApiResponse updateRole(UUID roleId, ActualizarRolDTO actualizarRolDTO) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
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

    private RolDTO convertToDTO(Role role) {
        return modelMapper.map(role, RolDTO.class);
    }

}