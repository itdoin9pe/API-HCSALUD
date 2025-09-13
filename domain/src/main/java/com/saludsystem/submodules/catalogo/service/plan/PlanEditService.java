package com.saludsystem.submodules.catalogo.service.plan;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.model.constant.PlanConstant;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;

public class PlanEditService
{
	private final PlanDao planDao;
	private final PlanRepository planRepository;

	public PlanEditService(PlanDao planDao, PlanRepository planRepository)
	{
		this.planDao = planDao;
		this.planRepository = planRepository;
	}

	public Plan execute(UUID uuid, Plan model)
	{
		var currentPlan = planDao.getById(uuid);
		if (currentPlan == null)
		{
			throw new IllegalArgumentException(PlanConstant.INVALID_ID);
		}
		if (currentPlan.getEstado() != null && currentPlan.getEstado() == 0)
		{
			throw new IllegalStateException("El plan ya se encuentra desactivado");
		}
		currentPlan.actualizarNombrePlan(model.getNombrePlan());
		currentPlan.actualizarFechaInicio(model.getFechaInicio());
		currentPlan.actualizarFechaFin(model.getFechaFinContrato());
		currentPlan.actualizarMaxPlan(model.getMaxPlan());
		currentPlan.actualizarUseMax(model.getUseMax());
		currentPlan.actualizarCostoPlan(model.getCostoPlan());
		currentPlan.actualizarEstado(model.getEstado());
		return planRepository.update(uuid, currentPlan);
	}
}