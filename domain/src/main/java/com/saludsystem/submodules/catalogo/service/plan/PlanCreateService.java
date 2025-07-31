package com.saludsystem.submodules.catalogo.service.plan;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;

public class PlanCreateService {

    private final PlanRepository planRepository;

    public PlanCreateService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan execute(Plan model) {
        return planRepository.save(model);
    }

}
