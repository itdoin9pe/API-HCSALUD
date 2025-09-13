package com.saludsystem.submodules.operaciones.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.PresentacionMapper;
import com.saludsystem.submodules.operaciones.model.dtos.PresentacionDTO;
import com.saludsystem.submodules.operaciones.port.dao.PresentacionDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class PresentacionAllHandler
{
	private final PresentacionDao presentacionDao;
	private final PresentacionMapper presentacionMapper;

	public PresentacionAllHandler(PresentacionDao presentacionDao, PresentacionMapper presentacionMapper)
	{
		this.presentacionDao = presentacionDao;
		this.presentacionMapper = presentacionMapper;
	}

	public ListResponse<PresentacionDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = presentacionDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<PresentacionDTO> data = result.getData().stream().map(presentacionMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}