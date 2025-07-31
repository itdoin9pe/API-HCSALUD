package com.saludsystem.submodules.catalogo.service.plan;

import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;

import java.util.UUID;

public class PlanDeleteService {

    private final PlanRepository planRepository;
    private final PlanDao planDao;

    public PlanDeleteService(PlanRepository planRepository, PlanDao planDao) {
        this.planRepository = planRepository;
        this.planDao = planDao;
    }

    public void execute(UUID uuid) {

        var plan = planDao.getById(uuid);

        if (plan.getEstado() != null && plan.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar un plan ya desactivado");

        }

        planRepository.delete(uuid);

    }
}
