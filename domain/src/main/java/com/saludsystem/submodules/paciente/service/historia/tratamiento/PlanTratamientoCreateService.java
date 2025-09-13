package com.saludsystem.submodules.paciente.service.historia.tratamiento;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.PlanTratamientoRepository;

public class PlanTratamientoCreateService
{
	private final PlanTratamientoRepository planTratamientoRepository;

	public PlanTratamientoCreateService(PlanTratamientoRepository planTratamientoRepository)
	{
		this.planTratamientoRepository = planTratamientoRepository;
	}

	public PlanTratamiento execute(PlanTratamiento planTratamiento)
	{
		return planTratamientoRepository.save(planTratamiento);
	}
}
