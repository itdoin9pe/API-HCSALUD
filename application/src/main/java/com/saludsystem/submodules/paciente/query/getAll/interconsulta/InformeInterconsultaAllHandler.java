package com.saludsystem.submodules.paciente.query.getAll.interconsulta;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InformeInterconsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InformeInterconsultaDTO;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InformeInterconsultaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class InformeInterconsultaAllHandler
{
	private final InformeInterconsultaDao informeInterconsultaDao;
	private final InformeInterconsultaMapper informeInterconsultaMapper;

	public InformeInterconsultaAllHandler(
		InformeInterconsultaDao informeInterconsultaDao,
		InformeInterconsultaMapper informeInterconsultaMapper)
	{
		this.informeInterconsultaDao = informeInterconsultaDao;
		this.informeInterconsultaMapper = informeInterconsultaMapper;
	}

	public ListResponse<InformeInterconsultaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = informeInterconsultaDao.getAll(hospitalId, paginationRequest.getPage(),
				paginationRequest.getRows());
		List<InformeInterconsultaDTO> data = result.getData().stream().map(informeInterconsultaMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}