package com.saludsystem.submodules.paciente.mapper.interconsulta;

import com.saludsystem.submodules.paciente.model.dtos.command.create.interconsulta.InterconsultaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.interconsulta.InterconsultaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InterconsultaDTO;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;

import java.util.UUID;

public class InterconsultaMapper {

    public Interconsulta fromCreateDto(InterconsultaCreateCommand createCommand) {

        return new Interconsulta(null, createCommand.getPacienteId(),
                createCommand.getMedicoSolicitante(), createCommand.getEspecialidadDestino(), createCommand.getMotivo(),
                createCommand.getFechaSolicitud(), createCommand.getEstado(), createCommand.getPrioridad(),
                createCommand.getObservaciones(), createCommand.getFechaAtencion());

    }

    public Interconsulta fromUpdateDto(UUID uuid, InterconsultaEditCommand editCommand) {

        return new Interconsulta(uuid, editCommand.getPacienteId(), editCommand.getMedicoSolicitante(),
                editCommand.getEspecialidadDestino(), editCommand.getMotivo(),
                editCommand.getFechaSolicitud(), editCommand.getEstado(), editCommand.getPrioridad(),
                editCommand.getObservaciones(), editCommand.getFechaAtencion());

    }

    public InterconsultaDTO toDto(Interconsulta model) {

        return new InterconsultaDTO(model.getPacienteInterconsultaId(), model.getPacienteId(),
                model.getMedicoSolicitante(), model.getEspecialidadDestino(), model.getMotivo(),
                model.getFechaSolicitud(), model.getEstado(), model.getPrioridad(),
                model.getObservaciones(), model.getFechaAtencion());

    }

}
