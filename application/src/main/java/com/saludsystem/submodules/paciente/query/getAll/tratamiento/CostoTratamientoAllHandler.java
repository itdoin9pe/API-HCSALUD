package com.saludsystem.submodules.paciente.query.getAll.tratamiento;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.tratamiento.CostoTratamientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.CostoTratamientoDTO;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.CostoTratamientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class CostoTratamientoAllHandler
{
	private final CostoTratamientoDao costoTratamientoDao;
	private final CostoTratamientoMapper costoTratamientoMapper;

	public CostoTratamientoAllHandler(
		CostoTratamientoDao costoTratamientoDao,
		CostoTratamientoMapper costoTratamientoMapper)
	{
		this.costoTratamientoDao = costoTratamientoDao;
		this.costoTratamientoMapper = costoTratamientoMapper;
	}

	public ListResponse<CostoTratamientoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = costoTratamientoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<CostoTratamientoDTO> data = result.getData().stream().map(costoTratamientoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}