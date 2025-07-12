package com.saludsystem.application.catalogo.command.edit;

import com.saludsystem.application.catalogo.dtos.put.ActualizarPlanDTO;
import com.saludsystem.application.catalogo.mapper.PlanMapper;
import com.saludsystem.domain.catalogo.port.in.service.PlanService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanEditHandler {
    private final PlanService planService;

    public PlanEditHandler(PlanService planService) {
        this.planService = planService;
    }

    public void execute(UUID uuid, ActualizarPlanDTO dto) {
        planService.update(uuid, PlanMapper.fromUpdateDto(uuid, dto));
    }
}
