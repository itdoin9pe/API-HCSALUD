package com.saludsystem.submodules.paciente.mapper.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento.PlanTratamientoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento.PlanTratamientoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.PlanTratamientoDTO;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;

import java.util.UUID;

public class PlanTratamientoMapper {

    public PlanTratamiento fromCreateDto(PlanTratamientoCreateCommand createCommand) {
        return new PlanTratamiento(
                null,
                createCommand.getPacienteId(),
                createCommand.getDoctorId(),
                createCommand.getEspecialidadId(),
                createCommand.getMedidaId(),
                createCommand.getFechaInicio(),
                createCommand.getFechaFin()
        );
    }

    public PlanTratamiento fromUpdateDto(UUID uuid, PlanTratamientoEditCommand editCommand) {
        return new PlanTratamiento(
                uuid,
                editCommand.getPacienteId(),
                editCommand.getDoctorId(),
                editCommand.getEspecialidadId(),
                editCommand.getMedidaId(),
                editCommand.getFechaInicio(),
                editCommand.getFechaFin()
        );
    }

    public PlanTratamientoDTO toDto(PlanTratamiento model) {
        return new PlanTratamientoDTO(
                model.getPacientePlanTratamientoId(),
                model.getPacienteId(),
                model.getDoctorId(),
                model.getEspecialidadId(),
                model.getMedidaId(),
                model.getFechaInicio(),
                model.getFechaFin()
        );
    }

}