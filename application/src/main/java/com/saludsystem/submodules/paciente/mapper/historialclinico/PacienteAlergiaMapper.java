package com.saludsystem.submodules.paciente.mapper.historialclinico;

import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.PacienteAlergiaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.PacienteAlergiaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;

import java.util.UUID;

public class PacienteAlergiaMapper {

    public PacienteAlergia fromCreateDto(PacienteAlergiaCreateCommand createCommand) {

        return new PacienteAlergia(null, createCommand.getPacienteId(), createCommand.getAlergiaId(),
                createCommand.getObservacion(), createCommand.getEstado());

    }

    public PacienteAlergia fromUpdateDto(UUID uuid, PacienteAlergiaEditCommand editCommand) {

        return new PacienteAlergia(uuid, editCommand.getPacienteId(), editCommand.getAlergiaId(),
                editCommand.getObservacion(), editCommand.getEstado());

    }

    public PacienteAlergiaDTO toDto(PacienteAlergia model) {

        return new PacienteAlergiaDTO(model.getPacienteAlergiaId(),
                model.getPacienteEntity(), model.getAlergiaEntity(),
                model.getObservacion(), model.getEstado());

    }

}