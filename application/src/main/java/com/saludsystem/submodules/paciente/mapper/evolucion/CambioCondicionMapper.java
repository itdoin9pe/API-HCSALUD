package com.saludsystem.submodules.paciente.mapper.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.CambioCondicionCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.CambioCondicionEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.CambioCondicionDTO;
import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;

public class CambioCondicionMapper
{
	public CambioCondicion fromCreateDto(CambioCondicionCreateCommand createCommand)
	{
		return new CambioCondicion(null, createCommand.getFecha(), createCommand.getDescripcion(),
				createCommand.getPacienteEvolucionId());
	}

	public CambioCondicion fromUpdateDto(Long id, CambioCondicionEditCommand editCommand)
	{
		return new CambioCondicion(id, editCommand.getFecha(), editCommand.getDescripcion(),
				editCommand.getPacienteEvolucionId());
	}

	public CambioCondicionDTO toDto(CambioCondicion model)
	{
		return new CambioCondicionDTO(model.getId(), model.getFecha(), model.getDescripcion(),
				model.getPacienteEvolucionId());
	}
}