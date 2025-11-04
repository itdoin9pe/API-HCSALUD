package com.saludsystem.submodules.operaciones.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.TipoMaterialMapper;
import com.saludsystem.submodules.operaciones.model.dtos.TipoMaterialDTO;
import com.saludsystem.submodules.operaciones.port.dao.TipoMaterialDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class TipoMaterialAllHandler
{
	private final TipoMaterialDao tipoMaterialDao;
	private final TipoMaterialMapper tipoMaterialMapper;

	public TipoMaterialAllHandler(TipoMaterialDao tipoMaterialDao, TipoMaterialMapper tipoMaterialMapper)
	{
		this.tipoMaterialDao = tipoMaterialDao;
		this.tipoMaterialMapper = tipoMaterialMapper;
	}

	public ListResponse<TipoMaterialDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = tipoMaterialDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<TipoMaterialDTO> data = result.getData().stream().map(tipoMaterialMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}