package com.saludSystem.Configuracion.Permisos.aplicacion.services;

import com.saludSystem.Configuracion.Permisos.aplicacion.dtos.ActualizarPermisoDTO;
import com.saludSystem.Configuracion.Permisos.aplicacion.dtos.CrearPermisoDTO;
import com.saludSystem.Configuracion.Permisos.aplicacion.dtos.PermisoDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;

import java.util.UUID;

public interface PermisoService {

    ApiResponse savePermiso(CrearPermisoDTO crearPermisoDTO);

    ApiResponse updatePermiso(UUID permisoId, ActualizarPermisoDTO actualizarPermisoDTO);

    ApiResponse deletePermiso(UUID permisoId);

    ListResponse<PermisoDTO> getAllPermisos(UUID hospitalId, int page, int rows);

    PermisoDTO getPermisoById(UUID permisoId);

}