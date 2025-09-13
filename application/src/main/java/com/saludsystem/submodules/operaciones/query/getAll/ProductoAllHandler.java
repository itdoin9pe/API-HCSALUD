package com.saludsystem.submodules.operaciones.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.ProductoMapper;
import com.saludsystem.submodules.operaciones.model.dtos.ProductoDTO;
import com.saludsystem.submodules.operaciones.port.dao.ProductoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class ProductoAllHandler
{
	private final ProductoDao productoDao;
	private final ProductoMapper productoMapper;

	public ProductoAllHandler(ProductoDao productoDao, ProductoMapper productoMapper)
	{
		this.productoDao = productoDao;
		this.productoMapper = productoMapper;
	}

	public ListResponse<ProductoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = productoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<ProductoDTO> data = result.getData().stream().map(productoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}