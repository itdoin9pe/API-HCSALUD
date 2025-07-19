package com.saludsystem.submodules.catalogo.service.plan;

import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;

import java.util.UUID;

public class PlanDeleteService {

    private final PlanRepository planRepository;

    public PlanDeleteService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public void execute(UUID uuid) {
        planRepository.delete(uuid);
    }
}
