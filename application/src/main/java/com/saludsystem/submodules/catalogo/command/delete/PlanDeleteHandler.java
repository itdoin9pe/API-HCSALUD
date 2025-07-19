package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.plan.PlanDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanDeleteHandler {

    private final PlanDeleteService planDeleteService;

    public PlanDeleteHandler(PlanDeleteService planDeleteService) {
        this.planDeleteService = planDeleteService;
    }

    public void execute(UUID uuid) {
        planDeleteService.execute(uuid);
    }
}
