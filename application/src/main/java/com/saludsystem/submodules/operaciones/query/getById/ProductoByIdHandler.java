package com.saludsystem.submodules.operaciones.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.ProductoMapper;
import com.saludsystem.submodules.operaciones.model.constant.ProductoConstant;
import com.saludsystem.submodules.operaciones.model.dtos.ProductoDTO;
import com.saludsystem.submodules.operaciones.port.dao.ProductoDao;

@Component
public class ProductoByIdHandler
{
	private final ProductoDao productoDao;
	private final ProductoMapper productoMapper;

	public ProductoByIdHandler(ProductoDao productoDao, ProductoMapper productoMapper)
	{
		this.productoDao = productoDao;
		this.productoMapper = productoMapper;
	}

	public ProductoDTO execute(UUID uuid)
	{
		var producto = productoDao.getById(uuid);
		if (producto == null)
		{
			throw new IllegalArgumentException(ProductoConstant.INVALID_ID);
		}
		return productoMapper.toDto(producto);
	}
}