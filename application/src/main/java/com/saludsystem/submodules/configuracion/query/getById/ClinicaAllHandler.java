package com.saludsystem.submodules.configuracion.query.getById;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.ClinicaMapper;
import com.saludsystem.submodules.configuracion.model.dtos.ClinicaDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.SysSaludDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class ClinicaAllHandler
{
	private final SysSaludDao sysSaludDao;
	private final ClinicaMapper clinicaMapper;

	public ClinicaAllHandler(SysSaludDao sysSaludDao, ClinicaMapper clinicaMapper)
	{
		this.sysSaludDao = sysSaludDao;
		this.clinicaMapper = clinicaMapper;
	}

	public ListResponse<ClinicaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = sysSaludDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<ClinicaDTO> data = result.getData().stream().map(clinicaMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}