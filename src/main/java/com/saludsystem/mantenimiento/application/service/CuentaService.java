package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.CuentaDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearCuentaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CuentaService extends GenericService<
        CrearCuentaDTO,
        CuentaDTO,
        UUID> {
}