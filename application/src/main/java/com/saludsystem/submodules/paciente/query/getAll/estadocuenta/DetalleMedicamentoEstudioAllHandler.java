package com.saludsystem.submodules.paciente.query.getAll.estadocuenta;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.DetalleMedicamentoEstudioMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.DetalleMedicamentoEstudioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class DetalleMedicamentoEstudioAllHandler
{
	private final DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao;
	private final DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper;

	public DetalleMedicamentoEstudioAllHandler(
		DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao,
		DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper)
	{
		this.detalleMedicamentoEstudioDao = detalleMedicamentoEstudioDao;
		this.detalleMedicamentoEstudioMapper = detalleMedicamentoEstudioMapper;
	}

	public ListResponse<DetalleMedicamentoEstudioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = detalleMedicamentoEstudioDao.getAll(hospitalId, paginationRequest.getPage(),
				paginationRequest.getRows());
		List<DetalleMedicamentoEstudioDTO> data = result.getData().stream().map(detalleMedicamentoEstudioMapper::toDto)
				.toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}