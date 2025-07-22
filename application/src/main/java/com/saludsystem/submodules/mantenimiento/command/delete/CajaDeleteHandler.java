package com.saludsystem.submodules.mantenimiento.command.delete;

import com.saludsystem.submodules.mantenimiento.service.caja.CajaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CajaDeleteHandler {

    private final CajaDeleteService cajaDeleteService;

    public CajaDeleteHandler(CajaDeleteService cajaDeleteService) {
        this.cajaDeleteService = cajaDeleteService;
    }

    public void execute(UUID uuid) {
        cajaDeleteService.execute(uuid);
    }
}
