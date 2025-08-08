package com.saludsystem.submodules.paciente.mapper;

import com.saludsystem.submodules.paciente.model.dtos.command.create.RecetaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.RecetaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.RecetaDTO;
import com.saludsystem.submodules.paciente.model.entity.Receta;

import java.util.UUID;

public class RecetaMapper {

    private final MedicamentoRecetadoMapper medicamentoMapper = new MedicamentoRecetadoMapper();

    public Receta fromCreateDto(RecetaCreateCommand createCommand) {
        return new Receta(
                null,
                createCommand.getFecha(),
                createCommand.getDoctorId(),
                createCommand.getPacienteId(),
                createCommand.getObservaciones(),
                createCommand.getEstado(),
                medicamentoMapper.fromDtoList(createCommand.getMedicamentos())
        );
    }

    public Receta fromUpdateDto(UUID id, RecetaEditCommand editCommand) {
        return new Receta(
                id,
                editCommand.getFecha(),
                editCommand.getDoctorId(),
                editCommand.getPacienteId(),
                editCommand.getObservaciones(),
                editCommand.getEstado(),
                medicamentoMapper.fromDtoList(editCommand.getMedicamentos())
        );
    }

    public RecetaDTO toDto(Receta model) {
        return new RecetaDTO(
                model.getPacienteRecetaId(),
                model.getDoctorId(),
                model.getPacienteId(),
                model.getFecha(),
                model.getObservaciones(),
                model.getEstado(),
                medicamentoMapper.toDtoList(model.getMedicamentosRecetados())
        );
    }

}