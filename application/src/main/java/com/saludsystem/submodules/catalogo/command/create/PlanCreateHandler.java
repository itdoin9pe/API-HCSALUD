package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dtos.post.CrearPlanDTO;
import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.port.in.service.PlanService;
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
