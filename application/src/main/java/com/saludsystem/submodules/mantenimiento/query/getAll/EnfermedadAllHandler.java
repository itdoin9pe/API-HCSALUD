package com.saludsystem.submodules.mantenimiento.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class EnfermedadAllHandler
{
	private final EnfermedadDao enfermedadDao;
	private final EnfermedadMapper enfermedadMapper;

	public EnfermedadAllHandler(EnfermedadDao enfermedadDao, EnfermedadMapper enfermedadMapper)
	{
		this.enfermedadDao = enfermedadDao;
		this.enfermedadMapper = enfermedadMapper;
	}

	public ListResponse<EnfermedadDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = enfermedadDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<EnfermedadDTO> data = result.getData().stream().map(enfermedadMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}