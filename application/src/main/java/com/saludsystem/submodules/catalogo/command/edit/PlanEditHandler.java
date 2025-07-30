package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.command.edit.PlanEditCommand;
import com.saludsystem.submodules.catalogo.service.plan.PlanEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanEditHandler {

    private final PlanEditService planEditService;

    public PlanEditHandler(PlanEditService planEditService) {
        this.planEditService = planEditService;
    }

    public void execute(UUID uuid, PlanEditCommand dto) {
        planEditService.execute(uuid, dto);
    }
}
