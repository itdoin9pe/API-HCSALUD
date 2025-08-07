package com.saludsystem.submodules.paciente.mapper;

import com.saludsystem.submodules.paciente.model.dtos.command.create.MedicamentoRecetadoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.MedicamentoRecetadoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.MedicamentoRecetadoDTO;
import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;

import java.util.UUID;

public class MedicamentoRecetadoMapper {

    public MedicamentoRecetado fromCreateDto(MedicamentoRecetadoCreateCommand createCommand) {
        return new MedicamentoRecetado(null, createCommand.getPacienteRecetaId(),
                createCommand.getMedicamentoId(), createCommand.getDosis(),
                createCommand.getFrecuencia(), createCommand.getDuracionDias(), createCommand.getIndicaciones());
    }

    public MedicamentoRecetado fromUpdateDto(UUID uuid, MedicamentoRecetadoEditCommand editCommand) {
        return new MedicamentoRecetado(null, editCommand.getPacienteRecetaId(),
                editCommand.getMedicamentoId(), editCommand.getDosis(),
                editCommand.getFrecuencia(), editCommand.getDuracionDias(), editCommand.getIndicaciones());
    }

    public MedicamentoRecetadoDTO toDto(MedicamentoRecetado model) {
        return new MedicamentoRecetadoDTO(
                model.getId(),
                model.getPacienteRecetaId(),
                model.getMedicamentoId(),
                model.getDosis(),
                model.getFrecuencia(),
                model.getDuracionDias(),
                model.getIndicaciones());
    }


}