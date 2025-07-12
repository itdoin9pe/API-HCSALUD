package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearPlanDTO;
import com.saludsystem.application.catalogo.mapper.PlanMapper;
import com.saludsystem.domain.catalogo.port.in.service.PlanService;
import org.springframework.stereotype.Component;

@Component
public class PlanCreateHandler {
    private final PlanService planService;

    public PlanCreateHandler(PlanService planService) {
        this.planService = planService;
    }

    public void execute(CrearPlanDTO dto) {
        planService.save(PlanMapper.fromCreateDto(dto));
    }
}
