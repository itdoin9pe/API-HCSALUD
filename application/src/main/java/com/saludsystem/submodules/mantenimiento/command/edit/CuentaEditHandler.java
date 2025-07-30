package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarCuentaDTO;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CuentaEditHandler {

    private final CuentaEditService cuentaEditService;

    public CuentaEditHandler(CuentaEditService cuentaEditService) {
        this.cuentaEditService = cuentaEditService;
    }

    public void execute(UUID uuid, ActualizarCuentaDTO dto) {
        cuentaEditService.execute(uuid, dto);
    }
}
