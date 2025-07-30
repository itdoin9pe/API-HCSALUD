package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.service.plan.PlanAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanAllHandler {

    private final PlanAllService planAllService;

    public PlanAllHandler(PlanAllService planAllService) {
        this.planAllService = planAllService;
    }

    public ListResponse<PlanDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return planAllService.execute(hospitalId, paginationRequest);
    }
}
