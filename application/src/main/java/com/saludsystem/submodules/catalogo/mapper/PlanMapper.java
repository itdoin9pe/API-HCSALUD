package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.PlanCreateCommandDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.PlanEditCommand;
import com.saludsystem.submodules.catalogo.model.Plan;

import java.util.UUID;

public class PlanMapper {

    public Plan fromCreateDto(PlanCreateCommandDTO dto) {
        return new Plan(null, dto.getNombrePlan(), dto.getFechaInicio(), dto.getFechaFinContrato(),
                dto.getMaxPlan(), dto.getUseMax(), dto.getCostoPlan(), dto.getEstado());
    }

    public Plan fromUpdateDto(UUID uuid, PlanEditCommand dto) {
        return new Plan(uuid, dto.getNombrePlan(), dto.getFechaInicio(), dto.getFechaFinContrato(),
                dto.getMaxPlan(), dto.getUseMax(), dto.getCostoPlan(), dto.getEstado());
    }

    public PlanDTO toDto(Plan model) {
        return new PlanDTO(model.getId(), model.getNombrePlan(), model.getFechaInicio(), model.getFechaFinContrato(),
                model.getMaxPlan(), model.getUseMax(), model.getCostoPlan(), model.getEstado());
    }
}