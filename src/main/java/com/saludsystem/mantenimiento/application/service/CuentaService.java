package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.CuentaResponse;
import com.saludsystem.mantenimiento.application.dto.req.CuentaRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CuentaService extends GenericService<
        CuentaRequest,
        CuentaResponse,
        UUID> {
}