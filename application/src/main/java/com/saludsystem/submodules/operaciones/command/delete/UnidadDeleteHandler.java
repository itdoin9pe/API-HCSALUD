package com.saludsystem.submodules.operaciones.command.delete;

import com.saludsystem.submodules.operaciones.service.unidad.UnidadDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UnidadDeleteHandler {

    private final UnidadDeleteService unidadDeleteService;

    public UnidadDeleteHandler(UnidadDeleteService unidadDeleteService) {
        this.unidadDeleteService = unidadDeleteService;
    }

    public void execute(UUID uuid) {

        unidadDeleteService.execute(uuid);

    }

}
