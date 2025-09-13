package com.saludsystem.submodules.principal.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.model.dtos.EmpresaDTO;
import com.saludsystem.submodules.principal.port.dao.EmpresaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class EmpresaAllHandler
{
	private final EmpresaDao empresaDao;
	private final EmpresaMapper empresaMapper;

	public EmpresaAllHandler(EmpresaDao empresaDao, EmpresaMapper empresaMapper)
	{
		this.empresaDao = empresaDao;
		this.empresaMapper = empresaMapper;
	}

	public ListResponse<EmpresaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = empresaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<EmpresaDTO> data = result.getData().stream().map(empresaMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}