package com.saludsystem.submodules.operaciones.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.service.proveedor.ProveedorDeleteService;

@Component
public class ProveedorDeleteHandler
{
	private final ProveedorDeleteService proveedorDeleteService;

	public ProveedorDeleteHandler(ProveedorDeleteService proveedorDeleteService)
	{
		this.proveedorDeleteService = proveedorDeleteService;
	}

	public void execute(UUID uuid)
	{
		proveedorDeleteService.execute(uuid);
	}
}