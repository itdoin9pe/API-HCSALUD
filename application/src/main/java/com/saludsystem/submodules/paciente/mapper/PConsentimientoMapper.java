package com.saludsystem.submodules.paciente.mapper;

import java.time.LocalTime;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.dtos.command.create.PConsentimientoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.PConsentimientoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.HoraDTO;
import com.saludsystem.submodules.paciente.model.dtos.get.PConsentimientoDTO;
import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;

public class PConsentimientoMapper
{
	public PacienteConsentimiento fromCreateDto(PConsentimientoCreateCommand createCommand)
	{
		LocalTime hora = null;
		HoraDTO horaDTO = createCommand.getHora();
		if (horaDTO != null)
		{
			hora = LocalTime.of(horaDTO.getHours(), horaDTO.getMinutes());
		}
		return new PacienteConsentimiento(null, createCommand.getPacienteId(), createCommand.getConsentimientoId(),
				createCommand.getCuerpo(), createCommand.getFecha(), hora, createCommand.getApoderadoNombre(),
				createCommand.getApoderadoDocumento(), createCommand.getApoderadoDireccion(),
				createCommand.getDoctorId(), createCommand.getEstado(), createCommand.getFirma());
	}

	public PacienteConsentimiento fromUpdateDto(UUID uuid, PConsentimientoEditCommand editCommand)
	{
		LocalTime hora = null;
		HoraDTO horaDTO = editCommand.getHora();
		if (horaDTO != null)
		{
			hora = LocalTime.of(horaDTO.getHours(), horaDTO.getMinutes());
		}
		return new PacienteConsentimiento(uuid, editCommand.getPacienteId(), editCommand.getConsentimientoId(),
				editCommand.getCuerpo(), editCommand.getFecha(), hora, editCommand.getApoderadoNombre(),
				editCommand.getApoderadoDocumento(), editCommand.getApoderadoDireccion(), editCommand.getDoctorId(),
				editCommand.getEstado(), editCommand.getFirma());
	}

	public PConsentimientoDTO toDto(PacienteConsentimiento model)
	{
		HoraDTO horaDTO = null;
		if (model.getHora() != null)
		{
			horaDTO = new HoraDTO();
		}
		return new PConsentimientoDTO(model.getPacienteConsentimientoId(), model.getPacienteId(),
				model.getConsentimientoId(), model.getCuerpo(), model.getFecha(), horaDTO, model.getApoderadoNombre(),
				model.getApoderadoDocumento(), model.getApoderadoDireccion(), model.getDoctorId(), model.getEstado(),
				model.getFirma());
	}
}