package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.get.PermisoDTO;
import com.saludsystem.configuracion.application.dto.post.CrearPermisoDTO;
import com.saludsystem.configuracion.application.dto.put.ActualizarPermisoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PermisoService extends GenericService<
        PermisoDTO,
        CrearPermisoDTO,
        ActualizarPermisoDTO,
        UUID> {
}