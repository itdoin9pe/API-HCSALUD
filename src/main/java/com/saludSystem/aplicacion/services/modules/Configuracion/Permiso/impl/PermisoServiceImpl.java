package com.saludSystem.aplicacion.services.modules.Configuracion.Permiso.impl;

import com.saludSystem.aplicacion.dtos.Configuracion.Permiso.ActualizarPermisoDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Permiso.CrearPermisoDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Permiso.PermisoDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;
import com.saludSystem.dominio.entities.Generals.Menu;
import com.saludSystem.dominio.entities.Configuracion.Role;
import com.saludSystem.dominio.entities.Configuracion.User;
import com.saludSystem.dominio.entities.Configuracion.Permiso;
import com.saludSystem.dominio.entities.Configuracion.SysSalud;
import com.saludSystem.infraestructura.security.exception.ResourceNotFoundException;
import com.saludSystem.infraestructura.repositories.Generals.MenuRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.PermisoRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.RoleRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.UserRepository;
import com.saludSystem.aplicacion.services.modules.Configuracion.Permiso.PermisoService;
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
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Usuario autenticado no encontrado"));
        boolean isAdmin = user.getRol().getNombre().equalsIgnoreCase("ADMINISTRADOR");
        if (!isAdmin) {
            return new ApiResponse(false, "No tienes permisos para asignar permisos.");
        }
        SysSalud hospital = user.getHospital();
        if (hospital == null) {
            return new ApiResponse(false, "El usuario autenticado no tiene un hospital asociado.");
        }
        Role rol = roleRepository.findById(crearPermisoDTO.getRolId())
                .orElseThrow( () -> new RuntimeException("Role no encontrado"));
        Menu menu = menuRepository.findById(crearPermisoDTO.getMenuId())
                .orElseThrow( () -> new RuntimeException("Menu no encontrado"));
        Permiso permiso = new Permiso();
        permiso.setDelete(crearPermisoDTO.getDelete());
        permiso.setInsert(crearPermisoDTO.getInsert());
        permiso.setRead(crearPermisoDTO.getRead());
        permiso.setUpdate(crearPermisoDTO.getUpdate());
        permiso.setUser(user);
        permiso.setHospital(hospital);
        permiso.setRol(rol);
        permiso.setMenu(menu);
        permisoRepository.save(permiso);
        return new ApiResponse(true, "Permiso registrado correctamente");
    }

    @Override
    public ApiResponse updatePermiso(UUID permisoId, ActualizarPermisoDTO actualizarPermisoDTO) {
        Permiso permiso = permisoRepository.findById(permisoId)
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
        Page<Permiso> permisoPage = permisoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PermisoDTO> data = permisoPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, permisoPage.getTotalElements(), permisoPage.getTotalPages(), permisoPage.getNumber() + 1);
    }

    @Override
    public PermisoDTO getPermisoById(UUID permisoId) {
        Permiso permiso = permisoRepository.findById(permisoId)
                .orElseThrow( () -> new ResourceNotFoundException("Permiso no encontrado"));
        PermisoDTO dto = new PermisoDTO();
        dto.setPermisoId(permiso.getPermisoId());
        dto.setDelete(permiso.getDelete());
        dto.setInsert(permiso.getInsert());
        dto.setRead(permiso.getRead());
        dto.setUpdate(permiso.getUpdate());
        return dto;
    }

    private PermisoDTO convertToDTO(Permiso permiso) {
        return modelMapper.map(permiso, PermisoDTO.class);
    }

}