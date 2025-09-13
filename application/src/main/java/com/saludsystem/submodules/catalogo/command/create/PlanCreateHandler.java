package com.saludsystem.submodules.catalogo.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.PlanCreateCommandDTO;
import com.saludsystem.submodules.catalogo.service.plan.PlanCreateService;

@Component
public class PlanCreateHandler
{
	private final PlanCreateService planCreateService;
	private final PlanMapper planMapper;

	public PlanCreateHandler(PlanCreateService planCreateService, PlanMapper planMapper)
	{
		this.planCreateService = planCreateService;
		this.planMapper = planMapper;
	}

	public void execute(PlanCreateCommandDTO createCommandDTO)
	{
		var plan = planMapper.fromCreateDto(createCommandDTO);
		planCreateService.execute(plan);
	}
}