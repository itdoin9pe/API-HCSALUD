package com.saludsystem.submodules.operaciones.mapper;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.TipoMaterial;
import com.saludsystem.submodules.operaciones.model.dtos.TipoMaterialDTO;
import com.saludsystem.submodules.operaciones.model.dtos.command.TipoMaterialCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.TipoMaterialEditCommand;

public class TipoMaterialMapper
{
	public TipoMaterial fromCreateDto(TipoMaterialCreateCommand createCommand)
	{
		return new TipoMaterial(null, createCommand.getNombre(), createCommand.getDescripcion(),
				createCommand.getEstado());
	}

	public TipoMaterial fromUpdateDto(UUID uuid, TipoMaterialEditCommand editCommand)
	{
		return new TipoMaterial(uuid, editCommand.getNombre(), editCommand.getDescripcion(), editCommand.getEstado());
	}

	public TipoMaterialDTO toDto(TipoMaterial tipoMaterial)
	{
		return new TipoMaterialDTO(tipoMaterial.getTipoMaterialId(), tipoMaterial.getNombre(),
				tipoMaterial.getDescripcion(), tipoMaterial.getEstado());
	}
}