package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.PlanDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearPlanDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarPlanDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface PlanService extends GenericService<
        PlanDTO,
        UUID,
        CrearPlanDTO,
        ActualizarPlanDTO> {
}