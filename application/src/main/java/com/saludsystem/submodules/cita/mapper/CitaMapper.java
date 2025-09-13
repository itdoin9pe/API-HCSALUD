package com.saludsystem.submodules.cita.mapper;

import java.util.UUID;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.model.dtos.CitaDTO;
import com.saludsystem.submodules.cita.model.dtos.command.CitaCreateCommand;
import com.saludsystem.submodules.cita.model.dtos.command.CitaEditCommand;
import com.saludsystem.submodules.cita.model.vo.CitaDoctorId;
import com.saludsystem.submodules.cita.model.vo.CitaEspecialidadId;
import com.saludsystem.submodules.cita.model.vo.CitaId;
import com.saludsystem.submodules.cita.model.vo.CitaMotivoConsulta;
import com.saludsystem.submodules.cita.model.vo.CitaObservacion;
import com.saludsystem.submodules.cita.model.vo.CitaPacienteId;
import com.saludsystem.submodules.cita.model.vo.CitaSedeId;
import com.saludsystem.submodules.cita.model.vo.CitaTipoCitadoId;

public class CitaMapper
{
	public Cita fromCreateDto(CitaCreateCommand dto)
	{
		return new Cita(null, new CitaEspecialidadId(dto.getEspecialidadId()), new CitaDoctorId(dto.getDoctorId()),
				dto.getFecha(), dto.getHoraInicio(), dto.getHoraFin(), new CitaPacienteId(dto.getPacienteId()),
				new CitaSedeId(dto.getSedeId()), new CitaTipoCitadoId(dto.getTipoCitadoId()), dto.getEstado(),
				new CitaMotivoConsulta(dto.getMotivoConsulta()), new CitaObservacion(dto.getObservacion()));
	}

	public Cita fromUpdateDto(UUID uuid, CitaEditCommand dto)
	{
		return new Cita(new CitaId(dto.getCitadoId()), new CitaEspecialidadId(dto.getEspecialidadId()),
				new CitaDoctorId(dto.getDoctorId()), dto.getFecha(), dto.getHoraInicio(), dto.getHoraFin(),
				new CitaPacienteId(dto.getPacienteId()), new CitaSedeId(dto.getSedeId()),
				new CitaTipoCitadoId(dto.getTipoCitadoId()), dto.getEstado(),
				new CitaMotivoConsulta(dto.getMotivoConsulta()), new CitaObservacion(dto.getObservacion()));
	}

	public CitaDTO toDto(Cita model)
	{
		return new CitaDTO(model.getId().value(), model.getEspecialidadId().value(), model.getDoctorId().value(),
				model.getFecha(), model.getHoraInicio(), model.getHoraFin(), model.getPacienteId().value(),
				model.getSedeId().value(), model.getTipoCitadoId().value(), model.getEstado(),
				model.getMotivoConsulta().value(), model.getObservacion().value());
	}
}