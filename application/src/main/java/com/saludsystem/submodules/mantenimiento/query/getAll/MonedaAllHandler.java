package com.saludsystem.submodules.mantenimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class MonedaAllHandler
{
	private final MonedaDao monedaDao;
	private final MonedaMapper monedaMapper;

	public MonedaAllHandler(MonedaDao monedaDao, MonedaMapper monedaMapper)
	{
		this.monedaDao = monedaDao;
		this.monedaMapper = monedaMapper;
	}

	public ListResponse<MonedaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = monedaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<MonedaDTO> data = result.getData().stream().map(monedaMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}