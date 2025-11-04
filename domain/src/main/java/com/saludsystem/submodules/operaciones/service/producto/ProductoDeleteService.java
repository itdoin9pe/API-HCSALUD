package com.saludsystem.submodules.operaciones.service.producto;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.port.dao.ProductoDao;
import com.saludsystem.submodules.operaciones.port.repository.ProductoRepository;

public class ProductoDeleteService
{
	private final ProductoRepository productoRepository;
	private final ProductoDao productoDao;

	public ProductoDeleteService(ProductoRepository productoRepository, ProductoDao productoDao)
	{
		this.productoRepository = productoRepository;
		this.productoDao = productoDao;
	}

	public void execute(UUID uuid)
	{
		var producto = productoDao.getById(uuid);
		if (producto.getEstadoProducto() != null && producto.getEstadoProducto() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un producto ya desactivado");
		}
		productoRepository.delete(uuid);
	}
}
