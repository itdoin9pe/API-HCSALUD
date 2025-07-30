package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.dtos.get.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CuentaByIdHandler {

    private final CuentaByIdService cuentaByIdService;

    public CuentaByIdHandler(CuentaByIdService cuentaByIdService) {
        this.cuentaByIdService = cuentaByIdService;
    }

    public CuentaDTO execute(UUID uuid) {
        return cuentaByIdService.execute(uuid);
    }

}
