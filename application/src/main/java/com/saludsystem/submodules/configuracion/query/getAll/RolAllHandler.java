package com.saludsystem.submodules.configuracion.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.RolMapper;
import com.saludsystem.submodules.configuracion.model.dtos.RolDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.RolDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class RolAllHandler
{
	private final RolDao rolDao;
	private final RolMapper rolMapper;

	public RolAllHandler(RolDao rolDao, RolMapper rolMapper)
	{
		this.rolDao = rolDao;
		this.rolMapper = rolMapper;
	}

	public ListResponse<RolDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = rolDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<RolDTO> data = result.getData().stream().map(rolMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}