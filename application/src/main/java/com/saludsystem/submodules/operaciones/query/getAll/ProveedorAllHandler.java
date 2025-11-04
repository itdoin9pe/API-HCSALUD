package com.saludsystem.submodules.operaciones.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.ProveedorMapper;
import com.saludsystem.submodules.operaciones.model.dtos.ProveedorDTO;
import com.saludsystem.submodules.operaciones.port.dao.ProveedorDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class ProveedorAllHandler
{
	private final ProveedorDao proveedorDao;
	private final ProveedorMapper proveedorMapper;

	public ProveedorAllHandler(ProveedorDao proveedorDao, ProveedorMapper proveedorMapper)
	{
		this.proveedorDao = proveedorDao;
		this.proveedorMapper = proveedorMapper;
	}

	public ListResponse<ProveedorDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = proveedorDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<ProveedorDTO> data = result.getData().stream().map(proveedorMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}