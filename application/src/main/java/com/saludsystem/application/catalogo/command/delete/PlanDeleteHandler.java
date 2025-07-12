package com.saludsystem.application.catalogo.command.delete;

import com.saludsystem.domain.catalogo.port.in.service.PlanService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanDeleteHandler {
    private final PlanService planService;

    public PlanDeleteHandler(PlanService planService) {
        this.planService = planService;
    }

    public void execute(UUID uuid) {
        planService.delete(uuid);
    }
}
