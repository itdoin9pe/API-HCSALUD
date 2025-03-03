package com.saludSystem.aplicacion.services.modules.Configuracion.Permiso;

import com.saludSystem.aplicacion.dtos.Configuracion.Permiso.ActualizarPermisoDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Permiso.CrearPermisoDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Permiso.PermisoDTO;
import com.saludSystem.aplicacion.dtos.responses.ApiResponse;
import com.saludSystem.aplicacion.dtos.responses.ListResponse;

import java.util.UUID;

public interface PermisoService {

    ApiResponse savePermiso(CrearPermisoDTO crearPermisoDTO);

    ApiResponse updatePermiso(UUID permisoId, ActualizarPermisoDTO actualizarPermisoDTO);

    ApiResponse deletePermiso(UUID permisoId);

    ListResponse<PermisoDTO> getAllPermisos(UUID hospitalId, int page, int rows);

    PermisoDTO getPermisoById(UUID permisoId);

}