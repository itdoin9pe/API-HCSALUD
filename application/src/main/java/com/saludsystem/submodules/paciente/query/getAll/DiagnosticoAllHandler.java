package com.saludsystem.submodules.paciente.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.DiagnosticoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.DiagnosticoDTO;
import com.saludsystem.submodules.paciente.port.dao.DiagnosticoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class DiagnosticoAllHandler
{
	private final DiagnosticoDao diagnosticoDao;
	private final DiagnosticoMapper diagnosticoMapper;

	public DiagnosticoAllHandler(DiagnosticoDao diagnosticoDao, DiagnosticoMapper diagnosticoMapper)
	{
		this.diagnosticoDao = diagnosticoDao;
		this.diagnosticoMapper = diagnosticoMapper;
	}

	public ListResponse<DiagnosticoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = diagnosticoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<DiagnosticoDTO> data = result.getData().stream().map(diagnosticoMapper::toDto).toList();
		return new ListResponse<DiagnosticoDTO>(data, result.getTotalElements(), result.getTotalPages(),
				result.getCurrentPage());
	}
}