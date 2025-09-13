package com.saludsystem.submodules.paciente.query.getAll.tratamiento;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.tratamiento.PlanTratamientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.PlanTratamientoDTO;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.PlanTratamientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class PlanTratamientoAllHandler
{
	private final PlanTratamientoDao planTratamientoDao;
	private final PlanTratamientoMapper planTratamientoMapper;

	public PlanTratamientoAllHandler(PlanTratamientoDao planTratamientoDao, PlanTratamientoMapper planTratamientoMapper)
	{
		this.planTratamientoDao = planTratamientoDao;
		this.planTratamientoMapper = planTratamientoMapper;
	}

	public ListResponse<PlanTratamientoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = planTratamientoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<PlanTratamientoDTO> data = result.getData().stream().map(planTratamientoMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}