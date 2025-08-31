package com.saludsystem.submodules.paciente.mapper.historialclinico;

import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.ExploracionFisicaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.ExploracionFisicaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;

import java.util.UUID;

public class ExploracionFisicaMapper {

    public ExploracionFisica fromCreateDto(ExploracionFisicaCreateCommand createCommand) {
        return new ExploracionFisica(null, createCommand.getPacienteId(),
                createCommand.getPresionArterial(), createCommand.getPulso(), createCommand.getTemperatura(),
                createCommand.getFrecuenciaCardiaca(), createCommand.getFrecuenciaRespiratoria(),
                createCommand.getPeso(), createCommand.getTalla(), createCommand.getMasa(),
                createCommand.getExamenClinico(), createCommand.getComplementoExamen());
    }

    public ExploracionFisica fromUpdateDto(UUID uuid, ExploracionFisicaEditCommand editCommand) {
        return new ExploracionFisica(uuid, editCommand.getPacienteId(), editCommand.getPresionArterial(),
                editCommand.getPulso(), editCommand.getTemperatura(), editCommand.getFrecuenciaCardiaca(),
                editCommand.getFrecuenciaRespiratoria(), editCommand.getPeso(), editCommand.getTalla(),
                editCommand.getMasa(), editCommand.getExamenClinico(), editCommand.getComplementoExamen());
    }

    public ExploracionFisicaDTO toDto(ExploracionFisica model) {
        return new ExploracionFisicaDTO(
                model.getPacienteExploracionId(),
                model.getPacienteId(), model.getPresionArterial(),
                model.getPulso(), model.getTemperatura(), model.getFrecuenciaCardiaca(),
                model.getFrecuenciaRespiratoria(), model.getPeso(), model.getTalla(),
                model.getMasa(), model.getExamenClinico(), model.getComplementoExamen()
        );
    }
}