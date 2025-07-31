package com.saludsystem.submodules.cita.mapper;

import com.saludsystem.submodules.cita.model.dtos.CitaDTO;
import com.saludsystem.submodules.cita.model.dtos.command.CitaCreateCommand;
import com.saludsystem.submodules.cita.model.dtos.command.CitaEditCommand;
import com.saludsystem.submodules.cita.model.entity.*;
import com.saludsystem.submodules.cita.model.vo.*;

import java.util.UUID;

public class CitaMapper {

    public Cita fromCreateDto(CitaCreateCommand dto) {

        return new Cita(
                null,
                new CitaEspecialidadId(dto.getEspecialidadId()),
                new CitaDoctorId(dto.getDoctorId()),
                dto.getFecha(),
                dto.getHoraInicio(),
                dto.getHoraFin(),
                new CitaPacienteId(dto.getPacienteId()),
                new CitaSedeId(dto.getSedeId()),
                new CitaTipoCitadoId(dto.getTipoCitadoId()),
                dto.getEstado(),
                new CitaMotivoConsulta(dto.getMotivoConsulta()),
                new CitaObservacion(dto.getObservacion())
        );

    }

    public Cita fromUpdateDto(UUID uuid, CitaEditCommand dto) {

        return new Cita(
                new CitaId(dto.getCitadoId()),
                new CitaEspecialidadId(dto.getEspecialidadId()),
                new CitaDoctorId(dto.getDoctorId()),
                dto.getFecha(),
                dto.getHoraInicio(),
                dto.getHoraFin(),
                new CitaPacienteId(dto.getPacienteId()),
                new CitaSedeId(dto.getSedeId()),
                new CitaTipoCitadoId(dto.getTipoCitadoId()),
                dto.getEstado(),
                new CitaMotivoConsulta(dto.getMotivoConsulta()),
                new CitaObservacion(dto.getObservacion())
        );

    }

    public CitaDTO toDto(Cita model) {
        return new CitaDTO(model.getId(), model.getDoctorId(), model.getFecha(), model.getHoraInicio(),
                model.getHoraFin(), model.getPacienteId(), model.getSedeId(), model.getTipoCitadoId(),
                model.getEstado(), model.getMotivoConsulta(), model.getObservacion());
    }
}