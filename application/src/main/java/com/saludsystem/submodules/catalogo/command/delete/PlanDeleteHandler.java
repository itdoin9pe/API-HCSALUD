package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.plan.PlanDeleteService;

@Component
public class PlanDeleteHandler
{
	private final PlanDeleteService planDeleteService;

	public PlanDeleteHandler(PlanDeleteService planDeleteService)
	{
		this.planDeleteService = planDeleteService;
	}

	public void execute(UUID uuid)
	{
		planDeleteService.execute(uuid);
	}
}