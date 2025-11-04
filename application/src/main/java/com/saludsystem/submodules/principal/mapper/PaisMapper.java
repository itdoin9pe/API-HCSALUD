package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.principal.model.dtos.PaisDTO;
import com.saludsystem.submodules.principal.model.dtos.command.PaisCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.command.edit.PaisEditCommand;

public class PaisMapper
{
	public Pais fromCreateDto(PaisCreateCommand dto)
	{
		return new Pais(null, dto.getIso(), dto.getNombre(), dto.getGentilicio(), dto.getOrden());
	}

	public Pais fromUpdateDto(Integer uuid, PaisEditCommand dto)
	{
		return new Pais(uuid, dto.getIso(), dto.getNombre(), dto.getGentilicio(), dto.getOrden());
	}

	public PaisDTO toDto(Pais model)
	{
		return new PaisDTO(model.getId(), model.getGentilicio(), model.getNombre(), model.getIso(), model.getOrden());
	}
}