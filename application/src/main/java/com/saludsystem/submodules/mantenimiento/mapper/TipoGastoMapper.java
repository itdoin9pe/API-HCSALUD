package com.saludsystem.submodules.mantenimiento.mapper;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoGasto;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoGastoCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TipoGastoEditCommand;

public class TipoGastoMapper
{
	public TipoGasto fromCreateDto(TipoGastoCreateCommand createCommand)
	{
		return new TipoGasto(null, createCommand.getNombre(), createCommand.getEstado());
	}

	public TipoGasto fromUpdateDto(UUID uuid, TipoGastoEditCommand editCommand)
	{
		return new TipoGasto(uuid, editCommand.getNombre(), editCommand.getEstado());
	}

	public TipoGastoDTO toDto(TipoGasto model)
	{
		return new TipoGastoDTO(model.getConceptoGastoId(), model.getNombre(), model.getEstado());
	}
}