package com.saludsystem.submodules.principal.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.SucursalMapper;
import com.saludsystem.submodules.principal.model.dtos.SucursalDTO;
import com.saludsystem.submodules.principal.port.dao.SucursalDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class SucursalAllHandler
{
	private final SucursalDao sucursalDao;
	private final SucursalMapper sucursalMapper;

	public SucursalAllHandler(SucursalDao sucursalDao, SucursalMapper sucursalMapper)
	{
		this.sucursalDao = sucursalDao;
		this.sucursalMapper = sucursalMapper;
	}

	public ListResponse<SucursalDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = sucursalDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<SucursalDTO> data = result.getData().stream().map(sucursalMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}