package com.saludsystem.submodules.movimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.CompraDetalleMapper;
import com.saludsystem.submodules.movimiento.model.dtos.CompraDetalleDTO;
import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class CompraDetalleAllHandler
{
	private final CompraDetalleDao compraDetalleDao;
	private final CompraDetalleMapper compraDetalleMapper;

	public CompraDetalleAllHandler(CompraDetalleDao compraDetalleDao, CompraDetalleMapper compraDetalleMapper)
	{
		this.compraDetalleDao = compraDetalleDao;
		this.compraDetalleMapper = compraDetalleMapper;
	}

	public ListResponse<CompraDetalleDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = compraDetalleDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<CompraDetalleDTO> data = result.getData().stream().map(compraDetalleMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}