package com.saludsystem.submodules.cita.mapper;

import com.saludsystem.submodules.cita.dtos.get.CitaDTO;
import com.saludsystem.submodules.cita.dtos.post.CrearCitaDTO;
import com.saludsystem.submodules.cita.dtos.put.ActualizarCitaDTO;
import com.saludsystem.submodules.cita.model.entity.*;
import com.saludsystem.submodules.cita.vo.*;

import java.util.UUID;

public class CitaMapper {

    public static Cita fromCreateDto(CrearCitaDTO dto) {

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

    public static Cita fromUpdateDto(UUID uuid, ActualizarCitaDTO dto) {

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

    public static CitaDTO toDto(Cita model) {
        return new CitaDTO(model.getId(), model.getDoctorId(), model.getFecha(), model.getHoraInicio(),
                model.getHoraFin(), model.getPacienteId(), model.getSedeId(), model.getTipoCitadoId(),
                model.getEstado(), model.getMotivoConsulta(), model.getObservacion());
    }
}