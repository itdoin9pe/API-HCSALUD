package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.service.plan.PlanListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanListHandler {

    private final PlanListService planListService;

    public PlanListHandler(PlanListService planListService) {
        this.planListService = planListService;
    }

    public List<PlanDTO> execute() {
        return planListService.execute();
    }
}
