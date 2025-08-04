package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.model.dtos.command.AseguradoraCreateCommand;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraCreateService;
import org.springframework.stereotype.Component;

@Component
public class AseguradoraCreateHandler {

    private final AseguradoraCreateService aseguradoraCreateService;
    private final AseguradoraMapper aseguradoraMapper;

    public AseguradoraCreateHandler(AseguradoraCreateService aseguradoraCreateService, AseguradoraMapper aseguradoraMapper) {
        this.aseguradoraCreateService = aseguradoraCreateService;
        this.aseguradoraMapper = aseguradoraMapper;
    }

    public void execute(AseguradoraCreateCommand createCommand) {

        var aseguradoraSaved =  aseguradoraMapper.fromCreateDto(createCommand);

        aseguradoraCreateService.execute(aseguradoraSaved);

    }

}
