package com.saludsystem.submodules.operaciones.mapper;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Marca;
import com.saludsystem.submodules.operaciones.model.dtos.MarcaDTO;
import com.saludsystem.submodules.operaciones.model.dtos.command.MarcaCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.MarcaEditCommand;

public class MarcaMapper
{
	public Marca fromCreateDto(MarcaCreateCommand createCommand)
	{
		return new Marca(null, createCommand.getNombre(), createCommand.getEstado());
	}

	public Marca fromUpdateDto(UUID uuid, MarcaEditCommand editCommand)
	{
		return new Marca(uuid, editCommand.getNombre(), editCommand.getEstado());
	}

	public MarcaDTO toDto(Marca model)
	{
		return new MarcaDTO(model.getId(), model.getNombre(), model.getEstado());
	}
}