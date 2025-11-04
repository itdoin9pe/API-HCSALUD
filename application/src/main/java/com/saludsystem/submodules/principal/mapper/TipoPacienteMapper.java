package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.TipoPaciente;
import com.saludsystem.submodules.principal.model.dtos.TipoPacienteDTO;
import com.saludsystem.submodules.principal.model.dtos.command.TipoPacienteCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.command.edit.TipoPacienteEditCommand;

public class TipoPacienteMapper
{
	public TipoPaciente fromCreateDto(TipoPacienteCreateCommand dto)
	{
		return new TipoPaciente(null, dto.getNombre());
	}

	public TipoPaciente fromUpdateDto(Long id, TipoPacienteEditCommand dto)
	{
		return new TipoPaciente(id, dto.getNombre());
	}

	public TipoPacienteDTO toDto(TipoPaciente model)
	{
		return new TipoPacienteDTO(model.getId(), model.getNombre());
	}
}