package com.saludsystem.submodules.movimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.VentaMapper;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDTO;
import com.saludsystem.submodules.movimiento.port.dao.VentaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class VentaAllHandler
{
	private final VentaDao ventaDao;
	private final VentaMapper ventaMapper;

	public VentaAllHandler(VentaDao ventaDao, VentaMapper ventaMapper)
	{
		this.ventaDao = ventaDao;
		this.ventaMapper = ventaMapper;
	}

	public ListResponse<VentaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = ventaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<VentaDTO> data = result.getData().stream().map(ventaMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}