package com.saludsystem.submodules.operaciones.command.create;

import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.MarcaCreateCommand;
import com.saludsystem.submodules.operaciones.service.marca.MarcaCreateService;
import org.springframework.stereotype.Component;

@Component
public class MarcaCreateHandler {

    private final MarcaCreateService marcaCreateService;
    private final MarcaMapper marcaMapper;

    public MarcaCreateHandler(MarcaCreateService marcaCreateService, MarcaMapper marcaMapper) {
        this.marcaCreateService = marcaCreateService;
        this.marcaMapper = marcaMapper;
    }

    public void execute(MarcaCreateCommand createCommand) {

        var marca = marcaMapper.fromCreateDto(createCommand);

        marcaCreateService.execute(marca);

    }

}
