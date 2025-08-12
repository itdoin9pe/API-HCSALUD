package com.saludsystem.submodules.paciente.mapper.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento.ProcedimientoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento.ProcedimientoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.ProcedimientoDTO;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;

import java.util.UUID;

public class ProcedimientoMapper {

    public Procedimiento fromCreateDto(ProcedimientoCreateCommand createCommand) {
        return new Procedimiento(
                null,
                createCommand.getPacienteId(),
                createCommand.getDoctorId(),
                createCommand.getTipoProcedimiento(),
                createCommand.getDescripcion(),
                createCommand.getFecha(),
                createCommand.getResultado()
        );
    }

    public Procedimiento fromUpdateDto(UUID uuid, ProcedimientoEditCommand editCommand) {
        return new Procedimiento(
                uuid,
                editCommand.getPacienteId(),
                editCommand.getDoctorId(),
                editCommand.getTipoProcedimiento(),
                editCommand.getDescripcion(),
                editCommand.getFecha(),
                editCommand.getResultado()
        );
    }

    public ProcedimientoDTO toDto(Procedimiento model) {
        return new ProcedimientoDTO(
                model.getProcedimientoId(),
                model.getPacienteId(),
                model.getDoctorId(),
                model.getTipoProcedimiento(),
                model.getDescripcion(),
                model.getFecha(),
                model.getResultado()
        );
    }

}