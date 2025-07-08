package com.saludsystem.configuracion.application.services;

import com.saludsystem.configuracion.application.dto.res.PermisoResponse;
import com.saludsystem.configuracion.application.dto.req.PermisoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PermisoService extends GenericService<
        PermisoRequest,
        PermisoResponse,
        UUID> {
}