package com.saludsystem.submodules.operaciones.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.service.producto.ProductoDeleteService;

@Component
public class ProductoDeleteHandler
{
	private final ProductoDeleteService productoDeleteService;

	public ProductoDeleteHandler(ProductoDeleteService productoDeleteService)
	{
		this.productoDeleteService = productoDeleteService;
	}

	public void execute(UUID uuid)
	{
		productoDeleteService.execute(uuid);
	}
}