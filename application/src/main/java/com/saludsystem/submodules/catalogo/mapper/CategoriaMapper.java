package com.saludsystem.submodules.catalogo.mapper;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.model.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.CategoriaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.CategoriaEditCommand;

public class CategoriaMapper
{
	public Categoria fromCreateDto(CategoriaCreateCommand dto)
	{
		return new Categoria(null, dto.getNombre(), dto.getEstado());
	}

	public Categoria fromUpdateDto(UUID uuid, CategoriaEditCommand dto)
	{
		return new Categoria(uuid, dto.getNombre(), dto.getEstado());
	}

	public CategoriaDTO toDto(Categoria model)
	{
		return new CategoriaDTO(model.getId(), model.getNombre(), model.getEstado());
	}
}