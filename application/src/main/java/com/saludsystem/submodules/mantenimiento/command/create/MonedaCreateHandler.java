package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearMonedaDTO;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaCreateService;
import org.springframework.stereotype.Component;

@Component
public class MonedaCreateHandler {

    private final MonedaCreateService monedaCreateService;

    public MonedaCreateHandler(MonedaCreateService monedaCreateService) {
        this.monedaCreateService = monedaCreateService;
    }

    public void execute(CrearMonedaDTO dto) {
        monedaCreateService.execute(dto);
    }
}
