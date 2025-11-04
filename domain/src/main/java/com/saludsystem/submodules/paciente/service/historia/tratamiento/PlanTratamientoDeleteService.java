package com.saludsystem.submodules.paciente.service.historia.tratamiento;

import java.util.UUID;

import com.saludsystem.submodules.paciente.port.dao.tratamiento.PlanTratamientoDao;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.PlanTratamientoRepository;

public class PlanTratamientoDeleteService
{
	private final PlanTratamientoRepository planTratamientoRepository;
	private final PlanTratamientoDao planTratamientoDao;

	public PlanTratamientoDeleteService(
		PlanTratamientoRepository planTratamientoRepository,
		PlanTratamientoDao planTratamientoDao)
	{
		this.planTratamientoRepository = planTratamientoRepository;
		this.planTratamientoDao = planTratamientoDao;
	}

	public void execute(UUID uuid)
	{
		var planTratamiento = planTratamientoDao.getById(uuid);
		if (planTratamiento.getEspecialidadId() != null)
		{
			throw new IllegalArgumentException("Mp se puede eliminar un plan de tratamiento invalido");
		}
		planTratamientoRepository.delete(uuid);
	}
}
