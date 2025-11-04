package com.saludsystem.submodules.paciente.mapper;

import com.saludsystem.submodules.paciente.model.dtos.command.create.EstudioResultadoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.EstudioResultadoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.EstudioResultadoDTO;
import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;

public class EstudioResultadoMapper
{
	public EstudioResultado fromCreateDto(EstudioResultadoCreateCommand createCommand)
	{
		return new EstudioResultado(null, createCommand.getReporteTexto(), createCommand.getUrlImg(),
				createCommand.getPacienteEstudioMedicoId());
	}

	public EstudioResultado fromUpdateDto(Long id, EstudioResultadoEditCommand editCommand)
	{
		return new EstudioResultado(id, editCommand.getReporteTexto(), editCommand.getUrlImg(),
				editCommand.getPacienteEstudioMedicoId());
	}

	public EstudioResultadoDTO toDto(EstudioResultado model)
	{
		return new EstudioResultadoDTO(model.getId(), model.getReporteTexto(), model.getUrlImg(),
				model.getEstudioMedicoId());
	}
}