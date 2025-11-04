package com.saludsystem.submodules.paciente.command.delete.tratamiento;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.tratamiento.PlanTratamientoDeleteService;

@Component
public class PlanTratamientoDeleteHandler
{
	private final PlanTratamientoDeleteService planTratamientoDeleteService;

	public PlanTratamientoDeleteHandler(PlanTratamientoDeleteService planTratamientoDeleteService)
	{
		this.planTratamientoDeleteService = planTratamientoDeleteService;
	}

	public void execute(UUID uuid)
	{
		planTratamientoDeleteService.execute(uuid);
	}
}