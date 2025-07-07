package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.CuentaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearCuentaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CuentaService extends GenericService<
        CrearCuentaDTO,
        CuentaDTO,
        UUID> {
}