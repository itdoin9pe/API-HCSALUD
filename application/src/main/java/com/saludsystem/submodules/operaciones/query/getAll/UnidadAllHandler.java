package com.saludsystem.submodules.operaciones.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.UnidadMapper;
import com.saludsystem.submodules.operaciones.model.dtos.UnidadDTO;
import com.saludsystem.submodules.operaciones.port.dao.UnidadDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class UnidadAllHandler
{
	private final UnidadDao unidadDao;
	private final UnidadMapper unidadMapper;

	public UnidadAllHandler(UnidadDao unidadDao, UnidadMapper unidadMapper)
	{
		this.unidadDao = unidadDao;
		this.unidadMapper = unidadMapper;
	}

	public ListResponse<UnidadDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = unidadDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<UnidadDTO> data = result.getData().stream().map(unidadMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}