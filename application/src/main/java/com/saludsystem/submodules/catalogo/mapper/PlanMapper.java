package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.dtos.get.PlanDTO;
import com.saludsystem.submodules.catalogo.dtos.post.CrearPlanDTO;
import com.saludsystem.submodules.catalogo.dtos.put.ActualizarPlanDTO;
import com.saludsystem.submodules.catalogo.model.Plan;

import java.util.UUID;

public class PlanMapper {

    public static Plan fromCreateDto(CrearPlanDTO dto) {
        return new Plan(null, dto.getNombrePlan(), dto.getFechaInicio(), dto.getFechaFinContrato(),
                dto.getMaxPlan(), dto.getUseMax(), dto.getCostoPlan(), dto.getEstado());
    }

    public static Plan fromUpdateDto(UUID uuid, ActualizarPlanDTO dto) {
        return new Plan(uuid, dto.getNombrePlan(), dto.getFechaInicio(), dto.getFechaFinContrato(),
                dto.getMaxPlan(), dto.getUseMax(), dto.getCostoPlan(), dto.getEstado());
    }

    public static PlanDTO toDto(Plan model) {
        return new PlanDTO(model.getId(), model.getNombrePlan(), model.getFechaInicio(), model.getFechaFinContrato(),
                model.getMaxPlan(), model.getUseMax(), model.getCostoPlan(), model.getEstado());
    }
}