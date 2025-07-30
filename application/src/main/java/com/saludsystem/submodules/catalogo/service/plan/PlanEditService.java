package com.saludsystem.submodules.catalogo.service.plan;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.dto.edit.ActualizarPlanDTO;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;

import java.util.UUID;

public class PlanEditService {

    private final PlanRepository planRepository;

    public PlanEditService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan execute(UUID uuid, ActualizarPlanDTO dto) {
        var updateToSave = PlanMapper.fromUpdateDto(uuid, dto);
        return planRepository.update(uuid, updateToSave);
    }
}
