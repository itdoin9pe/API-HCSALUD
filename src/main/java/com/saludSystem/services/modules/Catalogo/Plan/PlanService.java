package com.saludSystem.services.modules.Catalogo.Plan;

import com.saludSystem.dtos.catalago.PlanDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlanService {

    PlanDTO savePlan(PlanDTO planDTO);

    List<PlanDTO> getAllPlan(UUID hospitalId, int page, int rows);

    void deletePlan(UUID planId);

    PlanDTO updatePlan(UUID planId, PlanDTO planDTO);

    Optional<PlanDTO> getPlanById(UUID planId);

    long getTotalCount();

}
