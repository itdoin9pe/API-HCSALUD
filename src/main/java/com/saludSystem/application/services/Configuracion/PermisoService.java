package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarPermisoDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearPermisoDTO;
import com.saludSystem.application.dtos.Configuracion.GET.PermisoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;

import java.util.UUID;

public interface PermisoService {

    ApiResponse savePermiso(CrearPermisoDTO crearPermisoDTO);

    ApiResponse updatePermiso(UUID permisoId, ActualizarPermisoDTO actualizarPermisoDTO);

    ApiResponse deletePermiso(UUID permisoId);

    ListResponse<PermisoDTO> getAllPermisos(UUID hospitalId, int page, int rows);

    PermisoDTO getPermisoById(UUID permisoId);

}