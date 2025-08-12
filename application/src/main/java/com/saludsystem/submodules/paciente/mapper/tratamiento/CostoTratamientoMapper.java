package com.saludsystem.submodules.paciente.mapper.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento.CostoTratamientoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento.CostoTratamientoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.CostoTratamientoDTO;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.CostoTratamiento;

import java.util.UUID;

public class CostoTratamientoMapper {

    public CostoTratamiento fromCreateDto(CostoTratamientoCreateCommand createCommand) {
        return new CostoTratamiento(
                null,
                createCommand.getPacienteId(),
                createCommand.getPacientePlanTratamientoId(),
                createCommand.getConcepto(),
                createCommand.getMonto(),
                createCommand.getMoneda(),
                createCommand.isPagado()
        );
    }

    public CostoTratamiento fromUpdateDto(UUID uuid, CostoTratamientoEditCommand editCommand) {
        return new CostoTratamiento(
                uuid,
                editCommand.getPacienteId(),
                editCommand.getPacientePlanTratamientoId(),
                editCommand.getConcepto(),
                editCommand.getMonto(),
                editCommand.getMoneda(),
                editCommand.isPagado()
        );
    }

    public CostoTratamientoDTO toDto(CostoTratamiento model) {
        return new CostoTratamientoDTO(
                model.getPacienteCostoTratamientoId(),
                model.getPacienteId(),
                model.getPlanTratamientoId(),
                model.getConcepto(),
                model.getMonto(),
                model.getMoneda(),
                model.isPagado()
        );
    }

}