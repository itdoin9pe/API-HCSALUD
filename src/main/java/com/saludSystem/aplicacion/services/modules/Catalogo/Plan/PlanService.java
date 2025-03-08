package com.saludSystem.aplicacion.services.modules.Catalogo.Plan;

import com.saludSystem.aplicacion.dtos.Catalogo.Plan.ActualizarPlanDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Plan.CrearPlanDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.Plan.PlanDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;

import java.util.UUID;

public interface PlanService {

    ApiResponse savePlan(CrearPlanDTO crearPlanDTO);

    ApiResponse deletePlan(UUID planId);

    ApiResponse updatePlan(UUID planId, ActualizarPlanDTO actualizarPlanDTO);

    ListResponse<PlanDTO> getAllPlan(UUID hospitalId, int page, int rows);

    PlanDTO getPlanById(UUID planId);

}