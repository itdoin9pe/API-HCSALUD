package com.saludsystem.submodules.paciente.command.edit;

import com.saludsystem.submodules.paciente.mapper.PacienteMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.PacienteEditCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.paciente.PacienteEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PacienteEditHandler {

    private final PacienteEditService pacienteEditService;
    private final PacienteMapper pacienteMapper;

    public PacienteEditHandler(PacienteEditService pacienteEditService, PacienteMapper pacienteMapper) {
        this.pacienteEditService = pacienteEditService;
        this.pacienteMapper = pacienteMapper;
    }

    public void execute(UUID uuid, PacienteEditCommand pacienteEditCommand) {

        var pacienteUpdate = pacienteMapper.fromUpdateDto(uuid, pacienteEditCommand);

        pacienteEditService.execute(uuid, pacienteUpdate);

    }

}
