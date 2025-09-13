package com.saludsystem.submodules.cita.query;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.model.dtos.CitaDTO;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class CitaAllHandler
{
	private final CitaDao citaDao;
	private final CitaMapper citaMapper;

	public CitaAllHandler(CitaDao citaDao, CitaMapper citaMapper)
	{
		this.citaDao = citaDao;
		this.citaMapper = citaMapper;
	}

	public ListResponse<CitaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = citaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<CitaDTO> data = result.getData().stream().map(citaMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}