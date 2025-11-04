package com.saludsystem.submodules.paciente.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.RecetaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.RecetaDTO;
import com.saludsystem.submodules.paciente.port.dao.RecetaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class RecetaAllHandler
{
	private final RecetaDao recetaDao;
	private final RecetaMapper recetaMapper;

	public RecetaAllHandler(RecetaDao recetaDao, RecetaMapper recetaMapper)
	{
		this.recetaDao = recetaDao;
		this.recetaMapper = recetaMapper;
	}

	public ListResponse<RecetaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = recetaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<RecetaDTO> data = result.getData().stream().map(recetaMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}