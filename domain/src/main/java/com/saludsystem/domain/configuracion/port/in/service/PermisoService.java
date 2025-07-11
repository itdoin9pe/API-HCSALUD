package com.saludsystem.domain.configuracion.port.in.service;


import com.configuracion.application.dto.get.PermisoDTO;
import com.configuracion.application.dto.post.CrearPermisoDTO;
import com.configuracion.application.dto.put.ActualizarPermisoDTO;
import com.saludsystem.domain.shared.port.in.GenericService;

import java.util.UUID;

public interface PermisoService extends GenericService<
        PermisoDTO,
        CrearPermisoDTO,
        ActualizarPermisoDTO,
        UUID> {
}