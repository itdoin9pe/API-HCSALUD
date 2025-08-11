package com.saludsystem.submodules.paciente.command.edit.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.PacienteAlergiaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.PacienteAlergiaEditCommand;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia.PacienteAlergiaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PacienteAlergiaEditHandler {

    private final PacienteAlergiaEditService pacienteAlergiaEditService;
    private final PacienteAlergiaMapper pacienteAlergiaMapper;

    public PacienteAlergiaEditHandler(PacienteAlergiaEditService pacienteAlergiaEditService, PacienteAlergiaMapper pacienteAlergiaMapper) {
        this.pacienteAlergiaEditService = pacienteAlergiaEditService;
        this.pacienteAlergiaMapper = pacienteAlergiaMapper;
    }

    public void execute(UUID uuid, PacienteAlergiaEditCommand editCommand) {

        var pacieteAlergiaUpdated = pacienteAlergiaMapper.fromUpdateDto(uuid, editCommand);

        pacienteAlergiaEditService.execute(uuid, pacieteAlergiaUpdated);

    }

}
