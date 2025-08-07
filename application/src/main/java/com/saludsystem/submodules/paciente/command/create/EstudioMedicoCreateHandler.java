package com.saludsystem.submodules.paciente.command.create;

import com.saludsystem.submodules.paciente.mapper.EstudioMedicoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.EstudioMedicoCreateCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico.EstudioMedicoCreateService;
import org.springframework.stereotype.Component;

@Component
public class EstudioMedicoCreateHandler {

    private final EstudioMedicoCreateService estudioMedicoCreateService;
    private final EstudioMedicoMapper estudioMedicoMapper;

    public EstudioMedicoCreateHandler(EstudioMedicoCreateService estudioMedicoCreateService, EstudioMedicoMapper estudioMedicoMapper) {
        this.estudioMedicoCreateService = estudioMedicoCreateService;
        this.estudioMedicoMapper = estudioMedicoMapper;
    }

    public void execute(EstudioMedicoCreateCommand createCommand) {

        var estudioMedicoSaved = estudioMedicoMapper.fromCreateDto(createCommand);

        estudioMedicoCreateService.execute(estudioMedicoSaved);

    }

}
