package com.saludsystem.submodules.operaciones.command.create;

import com.saludsystem.submodules.operaciones.mapper.UnidadMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.UnidadCreateCommand;
import com.saludsystem.submodules.operaciones.service.unidad.UnidadCreateService;
import org.springframework.stereotype.Component;

@Component
public class UnidadCreateHandler {

    private final UnidadCreateService unidadCreateService;
    private final UnidadMapper unidadMapper;

    public UnidadCreateHandler(UnidadCreateService unidadCreateService, UnidadMapper unidadMapper) {
        this.unidadCreateService = unidadCreateService;
        this.unidadMapper = unidadMapper;
    }

    public void execute(UnidadCreateCommand createCommand) {

        var unidad = unidadMapper.fromCreateDto(createCommand);

        unidadCreateService.execute(unidad);

    }

}
