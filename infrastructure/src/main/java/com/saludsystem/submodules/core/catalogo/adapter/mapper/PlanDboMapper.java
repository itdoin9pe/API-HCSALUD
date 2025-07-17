package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.core.catalogo.adapter.entity.PlanEntity;

public class PlanDboMapper {

    public static PlanEntity toEntity(Plan model) {
        PlanEntity e = new PlanEntity();
        e.setNombrePlan(model.getNombrePlan());
        e.setFechaInicio(model.getFechaInicio());
        e.setFechaFinContrato(model.getFechaFinContrato());
        e.setMaxPlan(model.getMaxPlan());
        e.setUsuMax(model.getUseMax());
        e.setCostoPlan(model.getCostoPlan());
        e.setEstado(model.getEstado());
        return e;
    }

    public static Plan toDomain(PlanEntity e) {
        return new Plan(e.getPlanId(),
                e.getNombrePlan(), e.getFechaInicio(), e.getFechaFinContrato(),
                e.getMaxPlan(), e.getUsuMax(), e.getCostoPlan(), e.getEstado());
    }
}
