package com.saludsystem.submodules.operaciones.mapper;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Unidad;
import com.saludsystem.submodules.operaciones.model.dtos.UnidadDTO;
import com.saludsystem.submodules.operaciones.model.dtos.command.UnidadCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.UnidadEditCommand;

public class UnidadMapper
{
	public Unidad fromCreateDto(UnidadCreateCommand createCommand)
	{
		return new Unidad(null, createCommand.getNombre(), createCommand.getSiglas(), createCommand.getDescripcion(),
				createCommand.getEstado());
	}

	public Unidad fromUpdateDto(UUID uuid, UnidadEditCommand editCommand)
	{
		return new Unidad(uuid, editCommand.getNombre(), editCommand.getSiglas(), editCommand.getDescripcion(),
				editCommand.getEstado());
	}

	public UnidadDTO toDto(Unidad unidad)
	{
		return new UnidadDTO(unidad.getUnidadId(), unidad.getNombre(), unidad.getSiglas(), unidad.getDescripcion(),
				unidad.getEstado());
	}
}