package com.saludsystem.application.catalogo.query.getAll;

import com.saludsystem.application.catalogo.dtos.get.PlanDTO;
import com.saludsystem.application.catalogo.mapper.PlanMapper;
import com.saludsystem.domain.catalogo.model.Plan;
import com.saludsystem.domain.catalogo.port.in.service.PlanService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PlanAllHandler {
    private final PlanService planService;

    public PlanAllHandler(PlanService planService) {
        this.planService = planService;
    }

    public List<PlanDTO> execute(UUID  hospitalId, int page, int rows) {
        List<Plan> models = planService.getAll(hospitalId, page, rows);
        return models.stream().map(PlanMapper::toDto).toList();
    }
}
