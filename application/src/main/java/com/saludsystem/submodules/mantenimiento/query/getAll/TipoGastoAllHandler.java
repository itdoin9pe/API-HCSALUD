package com.saludsystem.submodules.mantenimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class TipoGastoAllHandler
{
	private final TipoGastoDao tipoGastoDao;
	private final TipoGastoMapper tipoGastoMapper;

	public TipoGastoAllHandler(TipoGastoDao tipoGastoDao, TipoGastoMapper tipoGastoMapper)
	{
		this.tipoGastoDao = tipoGastoDao;
		this.tipoGastoMapper = tipoGastoMapper;
	}

	public ListResponse<TipoGastoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = tipoGastoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<TipoGastoDTO> data = result.getData().stream().map(tipoGastoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}