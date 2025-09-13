package com.saludsystem.submodules.mantenimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class TipoTarjetaAllHandler
{
	private final TipoTarjetaDao tipoTarjetaDao;
	private final TipoTarjetaMapper tipoTarjetaMapper;

	public TipoTarjetaAllHandler(TipoTarjetaDao tipoTarjetaDao, TipoTarjetaMapper tipoTarjetaMapper)
	{
		this.tipoTarjetaDao = tipoTarjetaDao;
		this.tipoTarjetaMapper = tipoTarjetaMapper;
	}

	public ListResponse<TipoTarjetaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = tipoTarjetaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<TipoTarjetaDTO> data = result.getData().stream().map(tipoTarjetaMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}