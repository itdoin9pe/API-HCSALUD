package com.saludsystem.submodules.catalogo.service.plan;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;

import java.util.UUID;

public class PlanEditService {

    private final PlanDao planDao;
    private final PlanRepository planRepository;

    public PlanEditService(PlanDao planDao, PlanRepository planRepository) {
        this.planDao = planDao;
        this.planRepository = planRepository;
    }

    public Plan execute(UUID uuid, Plan model) {

        var currentPlan = planDao.getById(uuid);

        if (currentPlan.getEstado() != null && currentPlan.getEstado() == 0) {

            throw new IllegalStateException("El plan ya se encuentra desactivado");

        }

        return planRepository.update(uuid, model);

    }

}
