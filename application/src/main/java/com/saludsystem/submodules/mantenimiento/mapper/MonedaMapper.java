package com.saludsystem.submodules.mantenimiento.mapper;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.model.dtos.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.MonedaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.MonedadEditCommand;

public class MonedaMapper
{
	public Moneda fromCreateDto(MonedaCreateCommand createCommand)
	{
		return new Moneda(null, createCommand.getDescripcion(), createCommand.getEstado());
	}

	public Moneda fromUpdateDto(UUID uuid, MonedadEditCommand editCommand)
	{
		return new Moneda(uuid, editCommand.getDescripcion(), editCommand.getEstado());
	}

	public MonedaDTO toDto(Moneda model)
	{
		return new MonedaDTO(model.getId(), model.getDescripcion(), model.getEstado());
	}
}