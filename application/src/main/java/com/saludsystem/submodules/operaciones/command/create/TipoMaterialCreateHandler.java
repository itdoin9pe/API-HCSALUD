package com.saludsystem.submodules.operaciones.command.create;

import com.saludsystem.submodules.operaciones.mapper.TipoMaterialMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.TipoMaterialCreateCommand;
import com.saludsystem.submodules.operaciones.service.tipo_material.TipoMaterialCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoMaterialCreateHandler {

    private final TipoMaterialCreateService tipoMaterialCreateService;
    private final TipoMaterialMapper tipoMaterialMapper;

    public TipoMaterialCreateHandler(TipoMaterialCreateService tipoMaterialCreateService, TipoMaterialMapper tipoMaterialMapper) {
        this.tipoMaterialCreateService = tipoMaterialCreateService;
        this.tipoMaterialMapper = tipoMaterialMapper;
    }

    public void execute(TipoMaterialCreateCommand tipoMaterialCreateCommand) {

        var tipoMaterial = tipoMaterialMapper.fromCreateDto(tipoMaterialCreateCommand);

        tipoMaterialCreateService.execute(tipoMaterial);

    }

}
