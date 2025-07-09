package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.get.CuentaDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearCuentaDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarCuentaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface CuentaService extends GenericService<
        CuentaDTO,
        CrearCuentaDTO,
        ActualizarCuentaDTO,
        UUID> {
}