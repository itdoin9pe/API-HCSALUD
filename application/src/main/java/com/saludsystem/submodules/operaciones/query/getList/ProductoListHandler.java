package com.saludsystem.submodules.operaciones.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.ProductoMapper;
import com.saludsystem.submodules.operaciones.model.Producto;
import com.saludsystem.submodules.operaciones.model.dtos.ProductoDTO;
import com.saludsystem.submodules.operaciones.port.dao.ProductoDao;

@Component
public class ProductoListHandler
{
	private final ProductoDao productoDao;
	private final ProductoMapper productoMapper;

	public ProductoListHandler(ProductoDao productoDao, ProductoMapper productoMapper)
	{
		this.productoDao = productoDao;
		this.productoMapper = productoMapper;
	}

	public List<ProductoDTO> execute()
	{
		List<Producto> productoList = productoDao.getList();
		return productoList.stream().map(productoMapper::toDto).toList();
	}
}