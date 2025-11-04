package com.saludsystem.submodules.mantenimiento.mapper;

import com.saludsystem.submodules.mantenimiento.model.Enfermedad;
import com.saludsystem.submodules.mantenimiento.model.dtos.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.EnfermedadCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.EnfermedadEditCommand;

public class EnfermedadMapper
{
	public Enfermedad fromCreateDto(EnfermedadCreateCommand createCommand)
	{
		return new Enfermedad(null, createCommand.getDescripcion(), createCommand.getEstado());
	}

	public Enfermedad fromUpdateDto(String id, EnfermedadEditCommand editCommand)
	{
		return new Enfermedad(id, editCommand.getDescripcion(), editCommand.getEstado());
	}

	public EnfermedadDTO toDto(Enfermedad model)
	{
		return new EnfermedadDTO(model.getId(), model.getDescripcion(), model.getEstado());
	}
}