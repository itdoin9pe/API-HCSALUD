package com.saludSystem.services.modules.configuration.Permiso;

import com.saludSystem.dtos.configuration.Permiso.ActualizarPermisoDTO;
import com.saludSystem.dtos.configuration.Permiso.CrearPermisoDTO;
import com.saludSystem.dtos.configuration.Permiso.PermisoDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.repositories.modules.Configuration.PermisoRepository;
import com.saludSystem.repositories.modules.Configuration.RoleRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.repositories.modules.Configuration.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PermisoServiceImpl implements PermisoService{

    private final PermisoRepository permisoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public PermisoServiceImpl(PermisoRepository permisoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.permisoRepository = permisoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public ApiResponse savePermiso(CrearPermisoDTO permisoDTO) {
        return null;
    }

    @Override
    public ApiResponse updatePermiso(UUID permisoId, ActualizarPermisoDTO permisoDTO) {
        return null;
    }

    @Override
    public ApiResponse deletePermiso(UUID permisoId) {
        return null;
    }

    @Override
    public ListResponse<PermisoDTO> getAllPermisos(UUID hospitalId, int page, int rows) {
        return null;
    }

    @Override
    public PermisoDTO getPermisoById(UUID permisoId) {
        return null;
    }

}