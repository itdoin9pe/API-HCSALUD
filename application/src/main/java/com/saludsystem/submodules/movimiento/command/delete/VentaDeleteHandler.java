package com.saludsystem.submodules.movimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.service.venta.VentaDeleteService;

@Component
public class VentaDeleteHandler
{
	private final VentaDeleteService ventaDeleteService;

	public VentaDeleteHandler(VentaDeleteService ventaDeleteService)
	{
		this.ventaDeleteService = ventaDeleteService;
	}

	public void execute(UUID uuid)
	{
		ventaDeleteService.execute(uuid);
	}
}