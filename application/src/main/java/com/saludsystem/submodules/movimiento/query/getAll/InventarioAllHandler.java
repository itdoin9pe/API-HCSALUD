package com.saludsystem.submodules.movimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.InventarioMapper;
import com.saludsystem.submodules.movimiento.model.dtos.InventarioDTO;
import com.saludsystem.submodules.movimiento.port.dao.InventarioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class InventarioAllHandler {

	private final InventarioDao inventarioDao;
	private final InventarioMapper inventarioMapper;
	
	/**
	 * @param inventarioDao
	 * @param inventarioMapper
	 */
	public InventarioAllHandler(InventarioDao inventarioDao, InventarioMapper inventarioMapper) {
		this.inventarioDao = inventarioDao;
		this.inventarioMapper = inventarioMapper;
	}

	public ListResponse<InventarioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
		var result = inventarioDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<InventarioDTO> data = result.getData()
				.stream()
				.map(inventarioMapper::toDto)
				.toList();
		return new ListResponse<>(data, 
				result.getTotalElements(), 
				result.getTotalPages(), 
				result.getCurrentPage());
	}
	
}