package com.saludSystem.Configuracion.Roles.aplicacion.services.impl;

import com.saludSystem.Configuracion.Roles.aplicacion.dtos.ActualizarRolDTO;
import com.saludSystem.Configuracion.Roles.aplicacion.dtos.CrearRolDTO;
import com.saludSystem.Configuracion.Roles.aplicacion.dtos.RolDTO;
import com.saludSystem.Configuracion.Roles.dominio.RoleModel;
import com.saludSystem.Configuracion.Roles.infraestructura.repositories.RoleRepository;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Configuracion.Roles.aplicacion.services.RolService;
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
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        RoleModel role = new RoleModel();
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
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<RoleModel> rolePage = roleRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<RolDTO> data = rolePage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, rolePage.getTotalElements(), rolePage.getTotalPages(), rolePage.getNumber() + 1);
    }

    @Override
    public RolDTO getRoleById(UUID roleId) {
        RoleModel role = roleRepository.findById(roleId).orElseThrow( () -> new ResourceNotFoundException("Role no encontrado"));
        RolDTO dto = new RolDTO();
        dto.setRoleId(role.getRoleId());
        dto.setNombre(role.getNombre());
        dto.setEstado(role.getEstado());
        return dto;
    }

    @Override
    public ApiResponse updateRole(UUID roleId, ActualizarRolDTO actualizarRolDTO) {
        RoleModel role = roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
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

    private RolDTO convertToDTO(RoleModel role) {
        return modelMapper.map(role, RolDTO.class);
    }

}