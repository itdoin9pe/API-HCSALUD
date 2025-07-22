package com.saludsystem.submodules.mantenimiento.command.delete;

import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CuentaDeleteHandler {

    private final CuentaDeleteService cuentaDeleteService;

    public CuentaDeleteHandler(CuentaDeleteService cuentaDeleteService) {
        this.cuentaDeleteService = cuentaDeleteService;
    }

    public void execute(UUID uuid) {
        cuentaDeleteService.execute(uuid);
    }
}
