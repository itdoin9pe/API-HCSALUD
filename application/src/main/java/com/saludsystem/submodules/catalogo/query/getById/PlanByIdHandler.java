package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.PlanDTO;
import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.in.service.PlanService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanByIdHandler {
    private final PlanService planService;

    public PlanByIdHandler(PlanService planService) {
        this.planService = planService;
    }

    public PlanDTO execute(UUID uuid) {
        Plan model = planService.getById(uuid);
        return PlanMapper.toDto(model);
    }
}
