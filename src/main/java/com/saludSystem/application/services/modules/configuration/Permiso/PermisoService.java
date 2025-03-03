package com.saludSystem.application.services.modules.configuration.Permiso;

import com.saludSystem.application.dtos.configuration.Permiso.ActualizarPermisoDTO;
import com.saludSystem.application.dtos.configuration.Permiso.CrearPermisoDTO;
import com.saludSystem.application.dtos.configuration.Permiso.PermisoDTO;
import com.saludSystem.application.dtos.responses.ApiResponse;
import com.saludSystem.application.dtos.responses.ListResponse;

import java.util.UUID;

public interface PermisoService {

    ApiResponse savePermiso(CrearPermisoDTO crearPermisoDTO);

    ApiResponse updatePermiso(UUID permisoId, ActualizarPermisoDTO actualizarPermisoDTO);

    ApiResponse deletePermiso(UUID permisoId);

    ListResponse<PermisoDTO> getAllPermisos(UUID hospitalId, int page, int rows);

    PermisoDTO getPermisoById(UUID permisoId);

}