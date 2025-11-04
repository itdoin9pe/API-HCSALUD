package com.saludsystem.submodules.paciente.mapper.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.AltaMedicaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.AltaMedicaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.AltaMedicaDTO;
import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;

public class AltaMedicaMapper
{
	public AltaMedica fromCreateDto(AltaMedicaCreateCommand createCommand)
	{
		return new AltaMedica(null, createCommand.getFecha(), createCommand.getResumenFinal(),
				createCommand.getPacienteEvolucionId());
	}

	public AltaMedica fromUpdateDto(Long id, AltaMedicaEditCommand editCommand)
	{
		return new AltaMedica(id, editCommand.getFecha(), editCommand.getResumenFinal(),
				editCommand.getPacienteEvolucionId());
	}

	public AltaMedicaDTO toDto(AltaMedica model)
	{
		return new AltaMedicaDTO(model.getId(), model.getFecha(), model.getResumenFinal(),
				model.getPacienteEvolucionId());
	}
}