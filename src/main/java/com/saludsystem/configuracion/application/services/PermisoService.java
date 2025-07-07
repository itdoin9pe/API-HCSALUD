package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.req.PermisoDTO;
import com.saludsystem.configuracion.application.dto.res.CrearPermisoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PermisoService extends GenericService<
        CrearPermisoDTO,
        PermisoDTO,
        UUID> {
}