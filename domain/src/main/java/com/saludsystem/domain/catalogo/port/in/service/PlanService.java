package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.catalogo.application.dtos.get.PlanDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearPlanDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarPlanDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PlanService extends GenericService<
        PlanDTO,
        CrearPlanDTO,
        ActualizarPlanDTO,
        UUID> {
}