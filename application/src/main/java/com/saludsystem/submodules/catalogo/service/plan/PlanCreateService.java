package com.saludsystem.submodules.catalogo.service.plan;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.dto.command.CrearPlanDTO;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;

public class PlanCreateService {

    private final PlanRepository planRepository;

    public PlanCreateService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan execute(CrearPlanDTO dto) {
        var planToSave = PlanMapper.fromCreateDto(dto);
        return planRepository.save(planToSave);
    }
}
