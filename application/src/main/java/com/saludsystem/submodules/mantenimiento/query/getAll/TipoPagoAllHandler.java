package com.saludsystem.submodules.mantenimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class TipoPagoAllHandler
{
	private final TipoPagoDao tipoPagoDao;
	private final TipoPagoMapper tipoPagoMapper;

	public TipoPagoAllHandler(TipoPagoDao tipoPagoDao, TipoPagoMapper tipoPagoMapper)
	{
		this.tipoPagoDao = tipoPagoDao;
		this.tipoPagoMapper = tipoPagoMapper;
	}

	public ListResponse<TipoPagoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = tipoPagoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<TipoPagoDTO> data = result.getData().stream().map(tipoPagoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}