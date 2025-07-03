package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.get.PlanDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearPlanDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarPlanDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PlanService extends GenericService<
        PlanDTO,
        UUID,
        CrearPlanDTO,
        ActualizarPlanDTO> {
}