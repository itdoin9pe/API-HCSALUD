package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.PlanDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearPlanDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PlanService extends GenericService<
        CrearPlanDTO,
        PlanDTO,
        UUID> {
}