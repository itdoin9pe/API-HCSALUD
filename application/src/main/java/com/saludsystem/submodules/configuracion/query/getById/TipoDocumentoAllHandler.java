package com.saludsystem.submodules.configuracion.query.getById;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.TipoDocumentoMapper;
import com.saludsystem.submodules.configuracion.model.dtos.TipoDocumentoDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.TipoDocumentoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class TipoDocumentoAllHandler
{
	private final TipoDocumentoDao tipoDocumentoDao;
	private final TipoDocumentoMapper tipoDocumentoMapper;

	public TipoDocumentoAllHandler(TipoDocumentoDao tipoDocumentoDao, TipoDocumentoMapper tipoDocumentoMapper)
	{
		this.tipoDocumentoDao = tipoDocumentoDao;
		this.tipoDocumentoMapper = tipoDocumentoMapper;
	}

	public ListResponse<TipoDocumentoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = tipoDocumentoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<TipoDocumentoDTO> data = result.getData().stream().map(tipoDocumentoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}