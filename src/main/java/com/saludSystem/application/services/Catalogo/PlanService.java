package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarPlanDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearPlanDTO;
import com.saludSystem.application.dtos.Catalogo.GET.PlanDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import java.util.UUID;

public interface PlanService {

    ApiResponse savePlan(CrearPlanDTO crearPlanDTO);

    ApiResponse deletePlan(UUID planId);

    ApiResponse updatePlan(UUID planId, ActualizarPlanDTO actualizarPlanDTO);

    ListResponse<PlanDTO> getAllPlan(UUID hospitalId, int page, int rows);

    PlanDTO getPlanById(UUID planId);

}