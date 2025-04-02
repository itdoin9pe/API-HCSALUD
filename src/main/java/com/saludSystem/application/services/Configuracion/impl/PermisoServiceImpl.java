package com.saludSystem.application.services.Configuracion.impl;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarPermisoDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearPermisoDTO;
import com.saludSystem.application.dtos.Configuracion.GET.PermisoDTO;
import com.saludSystem.application.services.Configuracion.PermisoService;
import com.saludSystem.domain.model.Configuracion.PermisoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.PermisoRepository;
import com.saludSystem.domain.model.Configuracion.RoleEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.RoleRepository;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal.MenuRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.model.Principal.MenuEntity;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PermisoServiceImpl implements PermisoService {

    private final PermisoRepository permisoRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    public PermisoServiceImpl(PermisoRepository permisoRepository, UserRepository userRepository, RoleRepository roleRepository, MenuRepository menuRepository, ModelMapper modelMapper) {
        this.permisoRepository = permisoRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse savePermiso(CrearPermisoDTO crearPermisoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        UserEntity user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Usuario autenticado no encontrado"));
        boolean isAdmin = user.getRol().getNombre().equalsIgnoreCase("ADMINISTRADOR");
        if (!isAdmin) {
            return new ApiResponse(false, "No tienes permisos para asignar permisos.");
        }
        SysSaludEntity hospital = user.getHospital();
        if (hospital == null) {
            return new ApiResponse(false, "El usuario autenticado no tiene un hospital asociado.");
        }
        RoleEntity rol = roleRepository.findById(crearPermisoDTO.getRolId())
                .orElseThrow( () -> new RuntimeException("Role no encontrado"));
        MenuEntity menuEntity = menuRepository.findById(crearPermisoDTO.getMenuId())
                .orElseThrow( () -> new RuntimeException("Menu no encontrado"));
        PermisoEntity permiso = new PermisoEntity();
        permiso.setDelete(crearPermisoDTO.getDelete());
        permiso.setInsert(crearPermisoDTO.getInsert());
        permiso.setRead(crearPermisoDTO.getRead());
        permiso.setUpdate(crearPermisoDTO.getUpdate());
        permiso.setUser(user);
        permiso.setHospital(hospital);
        permiso.setRol(rol);
        permiso.setMenuEntity(menuEntity);
        permisoRepository.save(permiso);
        return new ApiResponse(true, "Permiso registrado correctamente");
    }

    @Override
    public ApiResponse updatePermiso(UUID permisoId, ActualizarPermisoDTO actualizarPermisoDTO) {
        PermisoEntity permiso = permisoRepository.findById(permisoId)
                .orElseThrow( () -> new ResourceNotFoundException("Permiso no encontrado"));
        Optional.ofNullable(actualizarPermisoDTO.getDelete()).ifPresent(permiso::setDelete);
        Optional.ofNullable(actualizarPermisoDTO.getInsert()).ifPresent(permiso::setInsert);
        Optional.ofNullable(actualizarPermisoDTO.getRead()).ifPresent(permiso::setRead);
        Optional.ofNullable(actualizarPermisoDTO.getUpdate()).ifPresent(permiso::setUpdate);
        permisoRepository.save(permiso);
        return new ApiResponse(true, "Permiso cambiado correctamente");
    }

    @Override
    public ApiResponse deletePermiso(UUID permisoId) {
        permisoRepository.deleteById(permisoId);
        return new ApiResponse(true, "Permiso quitado correctamente");
    }

    @Override
    public ListResponse<PermisoDTO> getAllPermisos(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PermisoEntity> permisoPage = permisoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PermisoDTO> data = permisoPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, permisoPage.getTotalElements(), permisoPage.getTotalPages(), permisoPage.getNumber() + 1);
    }

    @Override
    public PermisoDTO getPermisoById(UUID permisoId) {
        PermisoEntity permiso = permisoRepository.findById(permisoId)
                .orElseThrow( () -> new ResourceNotFoundException("Permiso no encontrado"));
        PermisoDTO dto = new PermisoDTO();
        dto.setPermisoId(permiso.getPermisoId());
        dto.setDelete(permiso.getDelete());
        dto.setInsert(permiso.getInsert());
        dto.setRead(permiso.getRead());
        dto.setUpdate(permiso.getUpdate());
        return dto;
    }

    private PermisoDTO convertToDTO(PermisoEntity permiso) {
        return modelMapper.map(permiso, PermisoDTO.class);
    }

}