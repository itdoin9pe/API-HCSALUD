package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dtos.put.ActualizarPlanDTO;
import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.port.in.service.PlanService;
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
