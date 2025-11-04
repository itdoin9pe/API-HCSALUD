package com.saludsystem.submodules.movimiento.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.VentaDetalleMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.VentaDetalleEditCommand;
import com.saludsystem.submodules.movimiento.service.ventadetalle.VentaDetalleEditService;

@Component
public class VentaDetalleEditHandler
{
	private final VentaDetalleEditService ventaDetalleEditService;
	private final VentaDetalleMapper ventaDetalleMapper;

	/**
	 * @param ventaDetalleEditService
	 * @param ventaDetalleMapper
	 */
	public VentaDetalleEditHandler(
		VentaDetalleEditService ventaDetalleEditService,
		VentaDetalleMapper ventaDetalleMapper)
	{
		this.ventaDetalleEditService = ventaDetalleEditService;
		this.ventaDetalleMapper = ventaDetalleMapper;
	}

	public void execute(UUID uuid, VentaDetalleEditCommand editCommand)
	{
		var ventaDetUpdated = ventaDetalleMapper.fromUpdateDto(uuid, editCommand);
		ventaDetalleEditService.execute(uuid, ventaDetUpdated);
	}
}