package com.saludsystem.submodules.configuracion.command.delete;

import com.saludsystem.submodules.configuracion.service.sede.SedeDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SedeDeleteHandler {

    private final SedeDeleteService sedeDeleteService;

    public SedeDeleteHandler(SedeDeleteService sedeDeleteService) {
        this.sedeDeleteService = sedeDeleteService;
    }

    public void execute(UUID uuid) {

        sedeDeleteService.execute(uuid);

    }

}
