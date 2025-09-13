package com.saludsystem.submodules.catalogo.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.PlanEditCommand;
import com.saludsystem.submodules.catalogo.service.plan.PlanEditService;

@Component
public class PlanEditHandler
{
	private final PlanEditService planEditService;
	private final PlanMapper planMapper;

	public PlanEditHandler(PlanEditService planEditService, PlanMapper planMapper)
	{
		this.planEditService = planEditService;
		this.planMapper = planMapper;
	}

	public void execute(UUID uuid, PlanEditCommand editCommand)
	{
		var plan = planMapper.fromUpdateDto(uuid, editCommand);
		planEditService.execute(uuid, plan);
	}
}