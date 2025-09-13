package com.saludsystem.submodules.configuracion.mapper;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.configuracion.model.dtos.PermisoDTO;
import com.saludsystem.submodules.configuracion.model.dtos.command.PermisoCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.PermisoEditCommand;

public class PermisoMapper
{
	public Permiso fromCreateDto(PermisoCreateCommand createCommand)
	{
		return new Permiso(null, createCommand.getInsert(), createCommand.getRead(), createCommand.getUpdate(),
				createCommand.getDelete(), createCommand.getRolId(), createCommand.getRolId());
	}

	public Permiso fromUpdateDto(UUID uuid, PermisoEditCommand editCommand)
	{
		return new Permiso(uuid, editCommand.getInsert(), editCommand.getRead(), editCommand.getUpdate(),
				editCommand.getDelete(), editCommand.getRolId(), editCommand.getRolId());
	}

	public PermisoDTO toDto(Permiso model)
	{
		return new PermisoDTO(model.getId(), model.getMenuId(), model.getRolId(), model.getInsert(), model.getRead(),
				model.getUpdate(), model.getDelete());
	}
}