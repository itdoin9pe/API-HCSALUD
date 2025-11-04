package com.saludsystem.submodules.operaciones.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.ProductoMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.ProductoCreateCommand;
import com.saludsystem.submodules.operaciones.service.producto.ProductoCreateService;

@Component
public class ProductoCreateHandler
{
	private final ProductoCreateService productoCreateService;
	private final ProductoMapper productoMapper;

	public ProductoCreateHandler(ProductoCreateService productoCreateService, ProductoMapper productoMapper)
	{
		this.productoCreateService = productoCreateService;
		this.productoMapper = productoMapper;
	}

	public void execute(ProductoCreateCommand createCommand)
	{
		var productoSaved = productoMapper.fromCreateDto(createCommand);
		productoCreateService.execute(productoSaved);
	}
}