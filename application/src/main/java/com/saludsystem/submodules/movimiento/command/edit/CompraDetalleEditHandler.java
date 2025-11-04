package com.saludsystem.submodules.movimiento.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.CompraDetalleMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.CompraDetalleEditCommand;
import com.saludsystem.submodules.movimiento.service.compradetalle.CompraDetalleEditService;

@Component
public class CompraDetalleEditHandler
{
	private final CompraDetalleEditService compraDetalleEditService;
	private final CompraDetalleMapper compraDetalleMapper;

	/**
	 * @param compraDetalleEditService
	 * @param compraDetalleMapper
	 */
	public CompraDetalleEditHandler(
		CompraDetalleEditService compraDetalleEditService,
		CompraDetalleMapper compraDetalleMapper)
	{
		this.compraDetalleEditService = compraDetalleEditService;
		this.compraDetalleMapper = compraDetalleMapper;
	}

	public void execute(UUID uuid, CompraDetalleEditCommand editCommand)
	{
		var compraDetalleUpdated = compraDetalleMapper.fromUpdateDto(uuid, editCommand);
		compraDetalleEditService.execute(uuid, compraDetalleUpdated);
	}
}