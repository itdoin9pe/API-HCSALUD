package com.saludsystem.submodules.operaciones.mapper;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.operaciones.model.dtos.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.model.dtos.command.CategotiaMatCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.CategoriaMatEditCommand;

public class CategoriaMaterialMapper
{
	public CategoriaMaterial fromCreateDto(CategotiaMatCreateCommand createCommand)
	{
		return new CategoriaMaterial(null, createCommand.getNombre(), createCommand.getDescripcion(),
				createCommand.getEstado());
	}

	public CategoriaMaterial fromUpdateDto(UUID uuid, CategoriaMatEditCommand editCommand)
	{
		return new CategoriaMaterial(uuid, editCommand.getNombre(), editCommand.getDescripcion(),
				editCommand.getEstado());
	}

	public CategoriaMatDTO toDto(CategoriaMaterial model)
	{
		return new CategoriaMatDTO(model.getCategoriaMaterialId(), model.getNombre(), model.getDescripcion(),
				model.getEstado());
	}
}