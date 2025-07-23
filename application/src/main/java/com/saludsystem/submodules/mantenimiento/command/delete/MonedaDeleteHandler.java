package com.saludsystem.submodules.mantenimiento.command.delete;

import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MonedaDeleteHandler {

    private final MonedaDeleteService monedaDeleteService;

    public MonedaDeleteHandler(MonedaDeleteService monedaDeleteService) {
        this.monedaDeleteService = monedaDeleteService;
    }

    public void execute(UUID uuid) {
        monedaDeleteService.execute(uuid);
    }
}
