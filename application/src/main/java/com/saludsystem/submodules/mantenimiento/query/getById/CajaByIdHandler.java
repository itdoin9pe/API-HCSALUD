package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.dtos.get.CajaDTO;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CajaByIdHandler {

    private final CajaByIdService cajaByIdService;

    public CajaByIdHandler(CajaByIdService cajaByIdService) {
        this.cajaByIdService = cajaByIdService;
    }

    public CajaDTO execute(UUID uuid) {
        return cajaByIdService.execute(uuid);
    }
}
