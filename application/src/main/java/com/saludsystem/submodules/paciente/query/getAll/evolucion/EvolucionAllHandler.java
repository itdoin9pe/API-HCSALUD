package com.saludsystem.submodules.paciente.query.getAll.evolucion;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.evolucion.EvolucionMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.EvolucionDTO;
import com.saludsystem.submodules.paciente.port.dao.evolucion.EvolucionDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class EvolucionAllHandler
{
	private final EvolucionDao evolucionDao;
	private final EvolucionMapper evolucionMapper;

	public EvolucionAllHandler(EvolucionDao evolucionDao, EvolucionMapper evolucionMapper)
	{
		this.evolucionDao = evolucionDao;
		this.evolucionMapper = evolucionMapper;
	}

	public ListResponse<EvolucionDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = evolucionDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<EvolucionDTO> data = result.getData().stream().map(evolucionMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}