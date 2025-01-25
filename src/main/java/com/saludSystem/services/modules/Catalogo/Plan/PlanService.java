package com.saludSystem.services.modules.Catalogo.Plan;

import com.saludSystem.dtos.catalago.Plan.ActualizarPlanDTO;
import com.saludSystem.dtos.catalago.Plan.CrearPlanDTO;
import com.saludSystem.dtos.catalago.Plan.PlanDTO;
import com.saludSystem.services.PaginatedService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlanService extends PaginatedService {

    CrearPlanDTO savePlan(CrearPlanDTO crearPlanDTO);

    void deletePlan(UUID planId);

    ActualizarPlanDTO updatePlan(UUID planId, ActualizarPlanDTO actualizarPlanDTO);

    Optional<PlanDTO> getPlanById(UUID planId);

}