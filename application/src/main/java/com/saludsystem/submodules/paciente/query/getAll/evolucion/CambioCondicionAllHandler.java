package com.saludsystem.submodules.paciente.query.getAll.evolucion;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.evolucion.CambioCondicionMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.CambioCondicionDTO;
import com.saludsystem.submodules.paciente.port.dao.evolucion.CambioCondicionDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class CambioCondicionAllHandler
{
	private final CambioCondicionDao cambioCondicionDao;
	private final CambioCondicionMapper cambioCondicionMapper;

	public CambioCondicionAllHandler(CambioCondicionDao cambioCondicionDao, CambioCondicionMapper cambioCondicionMapper)
	{
		this.cambioCondicionDao = cambioCondicionDao;
		this.cambioCondicionMapper = cambioCondicionMapper;
	}

	public ListResponse<CambioCondicionDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = cambioCondicionDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<CambioCondicionDTO> data = result.getData().stream().map(cambioCondicionMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}