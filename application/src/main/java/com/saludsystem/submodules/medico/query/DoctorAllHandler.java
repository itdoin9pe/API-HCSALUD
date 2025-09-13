package com.saludsystem.submodules.medico.query;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.model.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.port.dao.DoctorDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class DoctorAllHandler
{
	private final DoctorDao doctorDao;
	private final DoctorMapper doctorMapper;

	public DoctorAllHandler(DoctorDao doctorDao, DoctorMapper doctorMapper)
	{
		this.doctorDao = doctorDao;
		this.doctorMapper = doctorMapper;
	}

	public ListResponse<DoctorDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = doctorDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<DoctorDTO> data = result.getData().stream().map(doctorMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}