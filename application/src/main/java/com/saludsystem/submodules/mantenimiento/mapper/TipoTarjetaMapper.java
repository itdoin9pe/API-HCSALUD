package com.saludsystem.submodules.mantenimiento.mapper;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoTarjetaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TipoTarjetaEditCommand;

public class TipoTarjetaMapper
{
	public TipoTarjeta fromCreateDto(TipoTarjetaCreateCommand createCommand)
	{
		return new TipoTarjeta(null, createCommand.getDescripcion(), createCommand.getEstado());
	}

	public TipoTarjeta fromUpdateDto(UUID uuid, TipoTarjetaEditCommand editCommand)
	{
		return new TipoTarjeta(uuid, editCommand.getDescripcion(), editCommand.getEstado());
	}

	public TipoTarjetaDTO toDto(TipoTarjeta model)
	{
		return new TipoTarjetaDTO(model.getTipoTarjetaId(), model.getDescripcion(), model.getEstado());
	}
}