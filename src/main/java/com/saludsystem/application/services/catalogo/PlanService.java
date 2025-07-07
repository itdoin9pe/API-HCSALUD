package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.req.PlanDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearPlanDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface PlanService extends GenericService<
        CrearPlanDTO,
        PlanDTO,
        UUID> {
}