package com.saludsystem.submodules.paciente.service.historia.tratamiento;

import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.tratamiento.PlanTratamientoConstant;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.PlanTratamientoDao;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.PlanTratamientoRepository;

public class PlanTratamientoEdtiService
{
	private final PlanTratamientoDao planTratamientoDao;
	private final PlanTratamientoRepository planTratamientoRepository;

	public PlanTratamientoEdtiService(
		PlanTratamientoDao planTratamientoDao,
		PlanTratamientoRepository planTratamientoRepository)
	{
		this.planTratamientoDao = planTratamientoDao;
		this.planTratamientoRepository = planTratamientoRepository;
	}

	public PlanTratamiento execute(UUID uuid, PlanTratamiento planTratamiento)
	{
		var currentPlanTratamiento = planTratamientoDao.getById(uuid);
		if (currentPlanTratamiento == null)
		{
			throw new IllegalArgumentException(PlanTratamientoConstant.INVALID_ID);
		}
		if (currentPlanTratamiento.getFechaInicio() != null
				&& currentPlanTratamiento.getFechaInicio().isBefore(LocalDate.now()))
		{
			throw new IllegalStateException("La fecha no puede ser anterior a la actual");
		}
		return planTratamientoRepository.update(uuid, planTratamiento);
	}
}
