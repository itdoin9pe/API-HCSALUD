package com.saludsystem.submodules.movimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.service.compradetalle.CompraDetalleDeleteService;

@Component
public class CompraDetalleDeleteHandler
{
	private final CompraDetalleDeleteService compraDetalleDeleteService;

	/**
	 * @param compraDetalleDeleteService
	 */
	public CompraDetalleDeleteHandler(CompraDetalleDeleteService compraDetalleDeleteService)
	{
		this.compraDetalleDeleteService = compraDetalleDeleteService;
	}

	public void execute(UUID uuid)
	{
		compraDetalleDeleteService.execute(uuid);
	}
}