package com.saludsystem.submodules.paciente.command.create;

import com.saludsystem.submodules.paciente.mapper.PacienteMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.PacienteCreateCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.paciente.PacienteCreateService;
import org.springframework.stereotype.Component;

@Component
public class PacienteCreateHandler {

    public final PacienteCreateService pacienteCreateService;
    public final PacienteMapper pacienteMapper;

    public PacienteCreateHandler(PacienteCreateService pacienteCreateService, PacienteMapper pacienteMapper) {
        this.pacienteCreateService = pacienteCreateService;
        this.pacienteMapper = pacienteMapper;
    }

    public void execute(PacienteCreateCommand createCommand) {

        var pacienteSaved = pacienteMapper.fromCreateDto(createCommand);

        pacienteCreateService.execute(pacienteSaved);

    }

}
