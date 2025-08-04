package com.saludsystem.submodules.operaciones.command.create;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.CategotiaMatCreateCommand;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialCreateService;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMaterialCreateHandler {

    private final CategoriaMaterialCreateService categoriaMaterialCreateService;
    private final CategoriaMaterialMapper categoriaMaterialMapper;

    public CategoriaMaterialCreateHandler(CategoriaMaterialCreateService categoriaMaterialCreateService, CategoriaMaterialMapper categoriaMaterialMapper) {
        this.categoriaMaterialCreateService = categoriaMaterialCreateService;
        this.categoriaMaterialMapper = categoriaMaterialMapper;
    }

    public void execute(CategotiaMatCreateCommand createCommand) {

        var catMat = categoriaMaterialMapper.fromCreateDto(createCommand);

        categoriaMaterialCreateService.execute(catMat);

    }

}
