package com.saludsystem.submodules.paciente.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.PConsentimientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.PConsentimientoDTO;
import com.saludsystem.submodules.paciente.port.dao.PConsentimientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class PConsentimientoAllHandler
{
	private final PConsentimientoDao pConsentimientoDao;
	private final PConsentimientoMapper pConsentimientoMapper;

	public PConsentimientoAllHandler(PConsentimientoDao pConsentimientoDao, PConsentimientoMapper pConsentimientoMapper)
	{
		this.pConsentimientoDao = pConsentimientoDao;
		this.pConsentimientoMapper = pConsentimientoMapper;
	}

	public ListResponse<PConsentimientoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = pConsentimientoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<PConsentimientoDTO> data = result.getData().stream().map(pConsentimientoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}