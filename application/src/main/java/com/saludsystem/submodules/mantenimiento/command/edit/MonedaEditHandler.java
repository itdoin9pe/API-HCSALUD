package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarMonedaDTO;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MonedaEditHandler {

    private final MonedaEditService monedaEditService;

    public MonedaEditHandler(MonedaEditService monedaEditService) {
        this.monedaEditService = monedaEditService;
    }

    public void execute(UUID uuid, ActualizarMonedaDTO dto) {
        monedaEditService.execute(uuid, dto);
    }
}
