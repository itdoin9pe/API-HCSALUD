package com.saludsystem.submodules.mantenimiento.mapper;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoPagoCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TipoPagoEditCommand;

public class TipoPagoMapper
{
	public TipoPago fromCreateDto(TipoPagoCreateCommand createCommand)
	{
		return new TipoPago(null, createCommand.getMetodoPago(), createCommand.getDescripcion(),
				createCommand.getEstado());
	}

	public TipoPago fromUpdateDto(UUID uuid, TipoPagoEditCommand editCommand)
	{
		return new TipoPago(uuid, editCommand.getMetodoPago(), editCommand.getDescripcion(), editCommand.getEstado());
	}

	public TipoPagoDTO toDto(TipoPago model)
	{
		return new TipoPagoDTO(model.getTipoPagoId(), model.getDescripcion(), model.getMetodoPago(), model.getEstado());
	}
}