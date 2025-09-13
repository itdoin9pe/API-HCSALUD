package com.saludsystem.submodules.catalogo.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class PlanAllHandler
{
	private final PlanDao planDao;
	private final PlanMapper planMapper;

	public PlanAllHandler(PlanDao planDao, PlanMapper planMapper)
	{
		this.planDao = planDao;
		this.planMapper = planMapper;
	}

	public ListResponse<PlanDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = planDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<PlanDTO> data = result.getData().stream().map(planMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}

}
