package com.saludsystem.submodules.operaciones.command.edit;

import com.saludsystem.submodules.operaciones.mapper.UnidadMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.UnidadEditCommand;
import com.saludsystem.submodules.operaciones.service.unidad.UnidadEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UnidadEditHandler {

    private final UnidadEditService unidadEditService;
    private final UnidadMapper unidadMapper;

    public UnidadEditHandler(UnidadEditService unidadEditService, UnidadMapper unidadMapper) {
        this.unidadEditService = unidadEditService;
        this.unidadMapper = unidadMapper;
    }

    public void execute(UUID uuid, UnidadEditCommand editCommand) {

        var unidad = unidadMapper.fromUpdateDto(uuid, editCommand);

        unidadEditService.execute(uuid, unidad);

    }

}
