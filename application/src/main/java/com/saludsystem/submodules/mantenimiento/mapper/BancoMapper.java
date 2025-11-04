package com.saludsystem.submodules.mantenimiento.mapper;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.mantenimiento.model.dtos.BancoDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.BancoCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.BancoEditCommand;

public class BancoMapper
{
	public Banco fromCreateDto(BancoCreateCommand createCommand)
	{
		return new Banco(null, createCommand.getDescripcion(), createCommand.getEstado());
	}

	public Banco fromUpdateDto(UUID uuid, BancoEditCommand editCommand)
	{
		return new Banco(uuid, editCommand.getDescripcion(), editCommand.getEstado());
	}

	public BancoDTO toDto(Banco model)
	{
		return new BancoDTO(model.getId(), model.getDescripcion(), model.getEstado());
	}
}