package com.saludsystem.submodules.operaciones.command.delete;

import com.saludsystem.submodules.operaciones.mapper.UnidadMapper;
import com.saludsystem.submodules.operaciones.service.unidad.UnidadDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UnidadDeleteHandler {

    private final UnidadDeleteService unidadDeleteService;
    private final UnidadMapper unidadMapper;

    public UnidadDeleteHandler(UnidadDeleteService unidadDeleteService, UnidadMapper unidadMapper) {
        this.unidadDeleteService = unidadDeleteService;
        this.unidadMapper = unidadMapper;
    }

    public void execute(UUID uuid) {

        unidadDeleteService.execute(uuid);

    }

}
