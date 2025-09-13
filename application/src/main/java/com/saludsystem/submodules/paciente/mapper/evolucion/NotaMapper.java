package com.saludsystem.submodules.paciente.mapper.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.NotaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.NotaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.NotaDTO;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;

public class NotaMapper
{
	public Nota fromCreateDto(NotaCreateCommand createCommand)
	{
		return new Nota(null, createCommand.getFecha(), createCommand.getTipo(), createCommand.getContenido(),
				createCommand.getPacienteEvolucionId());
	}

	public Nota fromUpdateDto(Long id, NotaEditCommand editCommand)
	{
		return new Nota(id, editCommand.getFecha(), editCommand.getTipo(), editCommand.getContenido(),
				editCommand.getPacienteEvolucionId());
	}

	public NotaDTO toDto(Nota model)
	{
		return new NotaDTO(model.getId(), model.getFecha(), model.getContenido(), model.getContenido(),
				model.getPacienteEvolucion());
	}
}