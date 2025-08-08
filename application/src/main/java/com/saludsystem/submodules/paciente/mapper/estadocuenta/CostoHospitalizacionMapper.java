package com.saludsystem.submodules.paciente.mapper.estadocuenta;

import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.CostoHospitalizacionCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.CostoHospitalizacionEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;

import java.util.UUID;

public class CostoHospitalizacionMapper {

    public CostoHospitalizacion fromCreateDto(CostoHospitalizacionCreateCommand createCommand) {

        return new CostoHospitalizacion(null, createCommand.getPacEstadoCuentaId(),
                createCommand.getPacienteId(), createCommand.getFechaIngreso(), createCommand.getFechaAlta(),
                createCommand.getTipoHabitacion(), createCommand.getCostoPorDia(), createCommand.getCantidadDias(),
                createCommand.getTotalCosto());

    }

    public CostoHospitalizacion fromUpdateDto(UUID uuid, CostoHospitalizacionEditCommand editCommand) {

        return new CostoHospitalizacion(null, editCommand.getPacEstadoCuentaId(),
                editCommand.getPacienteId(), editCommand.getFechaIngreso(), editCommand.getFechaAlta(),
                editCommand.getTipoHabitacion(), editCommand.getCostoPorDia(), editCommand.getCantidadDias(),
                editCommand.getTotalCosto());

    }

    public CostoHospitalizacionDTO toDto(CostoHospitalizacion model) {

        return new CostoHospitalizacionDTO(
                model.getPec_costoHospitalizacionId(),
                model.getEstadoCuentaId(),
                model.getPacienteId(),
                model.getFechaIngreso(),
                model.getFechaAlta(),
                model.getTipoHabitacion(),
                model.getCostoPorDia(),
                model.getCantidadDias(),
                model.getTotalCosto());

    }

}