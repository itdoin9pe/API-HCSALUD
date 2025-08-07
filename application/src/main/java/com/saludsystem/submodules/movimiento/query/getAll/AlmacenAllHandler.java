package com.saludsystem.submodules.movimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.AlmacenMapper;
import com.saludsystem.submodules.movimiento.model.dtos.AlmacenDTO;
import com.saludsystem.submodules.movimiento.port.dao.AlmacenDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class AlmacenAllHandler {

	private final AlmacenDao almacenDao;
	private final AlmacenMapper almacenMapper;
	
	/**
	 * @param almacenDao
	 * @param almacenMapper
	 */
	public AlmacenAllHandler(AlmacenDao almacenDao, AlmacenMapper almacenMapper) {
		this.almacenDao = almacenDao;
		this.almacenMapper = almacenMapper;
	}
	
	public ListResponse<AlmacenDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
		
		var result = almacenDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		
		List<AlmacenDTO> data = result.getData()
				.stream()
				.map(almacenMapper::toDto)
				.toList();

		return new ListResponse<AlmacenDTO>(data, 
				result.getTotalElements(), 
				result.getTotalPages(), 
				result.getCurrentPage());
		
	}
	
}
