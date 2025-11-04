package com.saludsystem.submodules.principal.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.model.dtos.PaisDTO;
import com.saludsystem.submodules.principal.port.dao.PaisDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class PaisAllHandler
{
	private final PaisDao paisDao;
	private final PaisMapper paisMapper;

	public PaisAllHandler(PaisDao paisDao, PaisMapper paisMapper)
	{
		this.paisDao = paisDao;
		this.paisMapper = paisMapper;
	}

	public ListResponse<PaisDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = paisDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<PaisDTO> data = result.getData().stream().map(paisMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}