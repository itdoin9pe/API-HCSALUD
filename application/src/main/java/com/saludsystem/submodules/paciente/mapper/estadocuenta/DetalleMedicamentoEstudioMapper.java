package com.saludsystem.submodules.paciente.mapper.estadocuenta;

import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.DetalleMedicamentoEstudioCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.DetalleMedicamentoEstudioEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;

import java.util.UUID;

public class DetalleMedicamentoEstudioMapper {

    public DetalleMedicamentoEstudio fromCreateDto(DetalleMedicamentoEstudioCreateCommand createCommand) {

        return new DetalleMedicamentoEstudio(null, createCommand.getPacienteId(),
                createCommand.getEstadoCuentaId(), createCommand.getTipo(), createCommand.getDescripcion(),
                createCommand.getCantidad(), createCommand.getCostoUnitario(), createCommand.getTotalCosto());

    }

    public DetalleMedicamentoEstudio fromUpdateDto(UUID uuid, DetalleMedicamentoEstudioEditCommand editCommand) {

        return new DetalleMedicamentoEstudio(uuid, editCommand.getPacienteId(), editCommand.getEstadoCuentaId(),
                editCommand.getTipo(), editCommand.getDescripcion(), editCommand.getCantidad(),
                editCommand.getCostoUnitario(), editCommand.getTotalCosto());

    }

    public DetalleMedicamentoEstudioDTO toDto(DetalleMedicamentoEstudio model) {

        return new DetalleMedicamentoEstudioDTO(model.getPec_detalleMedicamentoId(),
                model.getPacienteId(),
                model.getEstadoCuentaId(),
                model.getTipo(),
                model.getDescripcion(),
                model.getCantidad(),
                model.getCostoUnitario(),
                model.getTotalCosto());

    }

}