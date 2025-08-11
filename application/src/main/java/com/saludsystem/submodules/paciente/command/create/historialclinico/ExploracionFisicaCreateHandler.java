package com.saludsystem.submodules.paciente.command.create.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ExploracionFisicaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.ExploracionFisicaCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica.ExploracionFisicaCreateService;
import org.springframework.stereotype.Component;

@Component
public class ExploracionFisicaCreateHandler {

    private final ExploracionFisicaCreateService exploracionFisicaCreateService;
    private final ExploracionFisicaMapper exploracionFisicaMapper;

    public ExploracionFisicaCreateHandler(ExploracionFisicaCreateService exploracionFisicaCreateService, ExploracionFisicaMapper exploracionFisicaMapper) {
        this.exploracionFisicaCreateService = exploracionFisicaCreateService;
        this.exploracionFisicaMapper = exploracionFisicaMapper;
    }

    public void execute(ExploracionFisicaCreateCommand createCommand) {

        var exploracionFisicaSaved = exploracionFisicaMapper.fromCreateDto(createCommand);

        exploracionFisicaCreateService.execute(exploracionFisicaSaved);

    }

}
