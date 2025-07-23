package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MonedaByIdHandler {

    private final MonedaByIdService monedaByIdService;

    public MonedaByIdHandler(MonedaByIdService monedaByIdService) {
        this.monedaByIdService = monedaByIdService;
    }

    public MonedaDTO execute(UUID uuid) {
        return monedaByIdService.execute(uuid);
    }
}
