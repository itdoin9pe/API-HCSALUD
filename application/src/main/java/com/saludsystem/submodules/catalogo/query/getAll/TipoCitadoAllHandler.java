package com.saludsystem.submodules.catalogo.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class TipoCitadoAllHandler
{
	private final TipoCitadoDao tipoCitadoDao;
	private final TipoCitadoMapper tipoCitadoMapper;

	public TipoCitadoAllHandler(TipoCitadoDao tipoCitadoDao, TipoCitadoMapper tipoCitadoMapper)
	{
		this.tipoCitadoDao = tipoCitadoDao;
		this.tipoCitadoMapper = tipoCitadoMapper;
	}

	public ListResponse<TipoCitadoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = tipoCitadoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<TipoCitadoDTO> data = result.getData().stream().map(tipoCitadoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}