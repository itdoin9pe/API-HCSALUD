package com.saludsystem.submodules.movimiento.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.VentaDetalleMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.VentaDetalleCreateCommand;
import com.saludsystem.submodules.movimiento.service.ventadetalle.VentaDetalleCreateService;

@Component
public class VentaDetalleCreateHandler
{
	private final VentaDetalleCreateService ventaDetalleCreateService;
	private final VentaDetalleMapper ventaDetalleMapper;

	/**
	 * @param ventaDetalleCreateService
	 * @param ventaDetalleMapper
	 */
	public VentaDetalleCreateHandler(
		VentaDetalleCreateService ventaDetalleCreateService,
		VentaDetalleMapper ventaDetalleMapper)
	{
		this.ventaDetalleCreateService = ventaDetalleCreateService;
		this.ventaDetalleMapper = ventaDetalleMapper;
	}

	public void execute(VentaDetalleCreateCommand createCommand)
	{
		var ventaDetSaved = ventaDetalleMapper.fromCreateDto(createCommand);
		ventaDetalleCreateService.execute(ventaDetSaved);
	}
}