package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.core.catalogo.adapter.entity.PlanEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import java.util.UUID;

public class PlanDboMapper {

    public static PlanEntity toEntity(Plan model, UUID userId, UUID hospitalId) {

        PlanEntity e = new PlanEntity();
        e.setNombrePlan(model.getNombrePlan());
        e.setFechaInicio(model.getFechaInicio());
        e.setFechaFinContrato(model.getFechaFinContrato());
        e.setMaxPlan(model.getMaxPlan());
        e.setUsuMax(model.getUseMax());
        e.setCostoPlan(model.getCostoPlan());
        e.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        e.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        e.setHospital(hospitalEntity);

        return e;
    }

    public static Plan toDomain(PlanEntity e) {

        return new Plan(e.getPlanId(),
                e.getNombrePlan(), e.getFechaInicio(), e.getFechaFinContrato(),
                e.getMaxPlan(), e.getUsuMax(), e.getCostoPlan(), e.getEstado());

    }
}
