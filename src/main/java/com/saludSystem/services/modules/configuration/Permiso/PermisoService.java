package com.saludSystem.services.modules.configuration.Permiso;

import com.saludSystem.dtos.configuration.Permiso.ActualizarPermisoDTO;
import com.saludSystem.dtos.configuration.Permiso.CrearPermisoDTO;
import com.saludSystem.dtos.configuration.Permiso.PermisoDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;

import java.util.UUID;

public interface PermisoService {

    ApiResponse savePermiso(CrearPermisoDTO crearPermisoDTO);

    ApiResponse updatePermiso(UUID permisoId, ActualizarPermisoDTO actualizarPermisoDTO);

    ApiResponse deletePermiso(UUID permisoId);

    ListResponse<PermisoDTO> getAllPermisos(UUID hospitalId, int page, int rows);

    PermisoDTO getPermisoById(UUID permisoId);

}