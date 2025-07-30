package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarCajaDTO;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CajaEditHandler {

    private final CajaEditService cajaEditService;

    public CajaEditHandler(CajaEditService cajaEditService) {
        this.cajaEditService = cajaEditService;
    }

    public void execute(UUID uuid, ActualizarCajaDTO dto) {
        cajaEditService.execute(uuid, dto);
    }
}
