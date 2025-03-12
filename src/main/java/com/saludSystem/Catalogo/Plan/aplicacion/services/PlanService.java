package com.saludSystem.Catalogo.Plan.aplicacion.services;

import com.saludSystem.Catalogo.Plan.aplicacion.dtos.ActualizarPlanDTO;
import com.saludSystem.Catalogo.Plan.aplicacion.dtos.CrearPlanDTO;
import com.saludSystem.Catalogo.Plan.aplicacion.dtos.PlanDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import java.util.UUID;

public interface PlanService {

    ApiResponse savePlan(CrearPlanDTO crearPlanDTO);

    ApiResponse deletePlan(UUID planId);

    ApiResponse updatePlan(UUID planId, ActualizarPlanDTO actualizarPlanDTO);

    ListResponse<PlanDTO> getAllPlan(UUID hospitalId, int page, int rows);

    PlanDTO getPlanById(UUID planId);

}