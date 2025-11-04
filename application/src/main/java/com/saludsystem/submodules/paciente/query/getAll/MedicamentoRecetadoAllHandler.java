package com.saludsystem.submodules.paciente.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.MedicamentoRecetadoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.MedicamentoRecetadoDTO;
import com.saludsystem.submodules.paciente.port.dao.MedicamentoRecetadoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class MedicamentoRecetadoAllHandler
{
	private final MedicamentoRecetadoDao medicamentoRecetadoDao;
	private final MedicamentoRecetadoMapper medicamentoRecetadoMapper;

	public MedicamentoRecetadoAllHandler(
		MedicamentoRecetadoDao medicamentoRecetadoDao,
		MedicamentoRecetadoMapper medicamentoRecetadoMapper)
	{
		this.medicamentoRecetadoDao = medicamentoRecetadoDao;
		this.medicamentoRecetadoMapper = medicamentoRecetadoMapper;
	}

	public ListResponse<MedicamentoRecetadoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = medicamentoRecetadoDao.getAll(hospitalId, paginationRequest.getPage(),
				paginationRequest.getRows());
		List<MedicamentoRecetadoDTO> data = result.getData().stream().map(medicamentoRecetadoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}