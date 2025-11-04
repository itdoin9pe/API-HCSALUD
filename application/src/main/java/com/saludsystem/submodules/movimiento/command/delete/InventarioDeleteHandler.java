package com.saludsystem.submodules.movimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.service.inventario.InventarioDeleteService;

@Component
public class InventarioDeleteHandler
{
	private final InventarioDeleteService inventarioDeleteService;

	/**
	 * @param inventarioDeleteService
	 */
	public InventarioDeleteHandler(InventarioDeleteService inventarioDeleteService)
	{
		this.inventarioDeleteService = inventarioDeleteService;
	}

	public void execute(UUID uuid)
	{
		inventarioDeleteService.execute(uuid);
	}
}