package com.saludsystem.submodules.movimiento.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.VentaMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.VentaEditCommand;
import com.saludsystem.submodules.movimiento.service.venta.VentaEditService;

@Component
public class VentaEditHandler
{
	private final VentaEditService ventaEditService;
	private final VentaMapper ventaMapper;

	public VentaEditHandler(VentaEditService ventaEditService, VentaMapper ventaMapper)
	{
		this.ventaEditService = ventaEditService;
		this.ventaMapper = ventaMapper;
	}

	public void execute(UUID uuid, VentaEditCommand editCommand)
	{
		var ventaUpdated = ventaMapper.fromUpdateDto(uuid, editCommand);
		ventaEditService.execute(uuid, ventaUpdated);
	}
}