package com.saludsystem.submodules.paciente.command.create;

import com.saludsystem.submodules.paciente.mapper.RecetaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.RecetaCreateCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.receta.RecetaCreateService;
import org.springframework.stereotype.Component;

@Component
public class RecetaCreateHandler {

    private final RecetaCreateService recetaCreateService;
    private final RecetaMapper recetaMapper;

    public RecetaCreateHandler(RecetaCreateService recetaCreateService, RecetaMapper recetaMapper) {
        this.recetaCreateService = recetaCreateService;
        this.recetaMapper = recetaMapper;
    }

    public void execute(RecetaCreateCommand createCommand) {

        var recetaSaved = recetaMapper.fromCreateDto(createCommand);

        recetaCreateService.execute(recetaSaved);

    }

}
