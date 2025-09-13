package com.saludsystem.submodules.mantenimiento.mapper;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.mantenimiento.model.dtos.CajaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.CajaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.CajaEditCommand;

public class CajaMapper
{
	public Caja fromCreateDto(CajaCreateCommand createCommand)
	{
		return new Caja(null, createCommand.getNombre(), createCommand.getEstado());
	}

	public Caja fromUpdateDto(UUID uuid, CajaEditCommand editCommand)
	{
		return new Caja(uuid, editCommand.getNombre(), editCommand.getEstado());
	}

	public CajaDTO toDto(Caja model)
	{
		return new CajaDTO(model.getId(), model.getNombre(), model.getEstado());
	}
}