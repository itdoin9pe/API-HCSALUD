package com.saludsystem.submodules.catalogo.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class TipoConceptoAllHandler
{
	private final TipoConceptoDao tipoConceptoDao;
	private final TipoConceptoMapper tipoConceptoMapper;

	public TipoConceptoAllHandler(TipoConceptoDao tipoConceptoDao, TipoConceptoMapper tipoConceptoMapper)
	{
		this.tipoConceptoDao = tipoConceptoDao;
		this.tipoConceptoMapper = tipoConceptoMapper;
	}

	public ListResponse<TipoConceptoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = tipoConceptoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<TipoConceptoDTO> data = result.getData().stream().map(tipoConceptoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}