package com.saludsystem.submodules.movimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.VentaDetalleMapper;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDetalleDTO;
import com.saludsystem.submodules.movimiento.port.dao.VentaDetalleDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class VentaDetalleAllHandler {

	private final VentaDetalleDao ventaDetalleDao;
	private final VentaDetalleMapper ventaDetalleMapper;
	
	/**
	 * @param ventaDetalleDao
	 * @param ventaDetalleMapper
	 */
	public VentaDetalleAllHandler(VentaDetalleDao ventaDetalleDao, VentaDetalleMapper ventaDetalleMapper) {
		this.ventaDetalleDao = ventaDetalleDao;
		this.ventaDetalleMapper = ventaDetalleMapper;
	}
	
	public ListResponse<VentaDetalleDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
		var result = ventaDetalleDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<VentaDetalleDTO> data = result.getData()
				.stream()
				.map(ventaDetalleMapper::toDto)
				.toList();
		return new ListResponse<VentaDetalleDTO>(data, 
				result.getTotalElements(), 
				result.getTotalPages(), 
				result.getCurrentPage());
	}

}
