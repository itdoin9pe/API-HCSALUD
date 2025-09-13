package com.saludsystem.submodules.operaciones.service.producto;

import com.saludsystem.submodules.operaciones.model.Producto;
import com.saludsystem.submodules.operaciones.port.repository.ProductoRepository;

public class ProductoCreateService
{
	private final ProductoRepository productoRepository;

	public ProductoCreateService(ProductoRepository productoRepository)
	{
		this.productoRepository = productoRepository;
	}

	public Producto execute(Producto producto)
	{
		return productoRepository.save(producto);
	}
}
