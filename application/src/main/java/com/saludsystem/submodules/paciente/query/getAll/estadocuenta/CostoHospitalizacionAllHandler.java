package com.saludsystem.submodules.paciente.query.getAll.estadocuenta;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.CostoHospitalizacionMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.CostoHospitalizacionDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class CostoHospitalizacionAllHandler
{
	private final CostoHospitalizacionDao costoHospitalizacionDao;
	private final CostoHospitalizacionMapper costoHospitalizacionMapper;

	public CostoHospitalizacionAllHandler(
		CostoHospitalizacionDao costoHospitalizacionDao,
		CostoHospitalizacionMapper costoHospitalizacionMapper)
	{
		this.costoHospitalizacionDao = costoHospitalizacionDao;
		this.costoHospitalizacionMapper = costoHospitalizacionMapper;
	}

	public ListResponse<CostoHospitalizacionDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = costoHospitalizacionDao.getAll(hospitalId, paginationRequest.getPage(),
				paginationRequest.getRows());
		List<CostoHospitalizacionDTO> data = result.getData().stream().map(costoHospitalizacionMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}