package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dto.command.CrearPlanDTO;
import com.saludsystem.submodules.catalogo.service.plan.PlanCreateService;
import org.springframework.stereotype.Component;

@Component
public class PlanCreateHandler {

    private final PlanCreateService planCreateService;

    public PlanCreateHandler(PlanCreateService planCreateService) {
        this.planCreateService = planCreateService;
    }

    public void execute(CrearPlanDTO dto) {
        planCreateService.execute(dto);
    }
}
