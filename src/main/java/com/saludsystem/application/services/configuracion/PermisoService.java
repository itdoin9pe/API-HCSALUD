package com.saludsystem.application.services.configuracion;

import com.saludsystem.application.dtos.configuracion.get.PermisoDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearPermisoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PermisoService extends GenericService<
        CrearPermisoDTO,
        PermisoDTO,
        UUID> {
}