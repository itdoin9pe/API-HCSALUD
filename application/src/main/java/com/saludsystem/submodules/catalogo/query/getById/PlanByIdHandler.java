package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.service.plan.PlanByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanByIdHandler {

    private final PlanByIdService planByIdService;

    public PlanByIdHandler(PlanByIdService planByIdService) {
        this.planByIdService = planByIdService;
    }

    public PlanDTO execute(UUID uuid) {
        return planByIdService.execute(uuid);
    }

}