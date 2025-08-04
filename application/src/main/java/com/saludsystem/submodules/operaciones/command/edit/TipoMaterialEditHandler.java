package com.saludsystem.submodules.operaciones.command.edit;

import com.saludsystem.submodules.operaciones.mapper.TipoMaterialMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.TipoMaterialEditCommand;
import com.saludsystem.submodules.operaciones.service.tipo_material.TipoMaterialEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoMaterialEditHandler {

    private final TipoMaterialEditService tipoMaterialEditService;
    private final TipoMaterialMapper tipoMaterialMapper;

    public TipoMaterialEditHandler(TipoMaterialEditService tipoMaterialEditService, TipoMaterialMapper tipoMaterialMapper) {
        this.tipoMaterialEditService = tipoMaterialEditService;
        this.tipoMaterialMapper = tipoMaterialMapper;
    }

    public void execute(UUID uuid, TipoMaterialEditCommand tipoMaterialEditCommand) {

        var tipoMaterial = tipoMaterialMapper.fromUpdateDto(uuid, tipoMaterialEditCommand);

        tipoMaterialEditService.execute(uuid, tipoMaterial);

    }

}
