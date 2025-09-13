package com.saludsystem.submodules.catalogo.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class MedicamentoAllHandler
{
	private final MedicamentoDao medicamentoDao;
	private final MedicamentoMapper medicamentoMapper;

	public MedicamentoAllHandler(MedicamentoDao medicamentoDao, MedicamentoMapper medicamentoMapper)
	{
		this.medicamentoDao = medicamentoDao;
		this.medicamentoMapper = medicamentoMapper;
	}

	public ListResponse<MedicamentoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = medicamentoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<MedicamentoDTO> data = result.getData().stream().map(medicamentoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}