package com.saludsystem.submodules.paciente.mapper;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.dtos.command.create.DiagnosticoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.DiagnosticoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.DiagnosticoDTO;
import com.saludsystem.submodules.paciente.model.entity.Diagnostico;

public class DiagnosticoMapper
{
	public Diagnostico fromCreateDto(DiagnosticoCreateCommand createCommand)
	{
		return new Diagnostico(null, createCommand.getPacienteId(), createCommand.getEnfermedadId(),
				createCommand.getFecha(), createCommand.getDescripcion());
	}

	public Diagnostico fromUpdateDto(UUID uuid, DiagnosticoEditCommand editCommand)
	{
		return new Diagnostico(uuid, editCommand.getPacienteId(), editCommand.getEnfermedadId(), editCommand.getFecha(),
				editCommand.getDescripcion());
	}

	public DiagnosticoDTO toDto(Diagnostico model)
	{
		return new DiagnosticoDTO(model.getId(), model.getPacienteId(), model.getEnfermedadId(), model.getFecha(),
				model.getDescripcion());
	}
}