package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.PlanDTO;
import com.saludsystem.application.catalogo.mapper.PlanMapper;
import com.saludsystem.domain.catalogo.model.Plan;
import com.saludsystem.domain.catalogo.port.in.service.PlanService;
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
