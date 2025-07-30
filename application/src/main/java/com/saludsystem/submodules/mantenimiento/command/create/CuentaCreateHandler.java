package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearCuentaDTO;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaCreateService;
import org.springframework.stereotype.Component;

@Component
public class CuentaCreateHandler {

    private final CuentaCreateService cuentaCreateService;

    public CuentaCreateHandler(CuentaCreateService cuentaCreateService) {
        this.cuentaCreateService = cuentaCreateService;
    }

    public void execute(CrearCuentaDTO dto) {
        cuentaCreateService.execute(dto);
    }
}
