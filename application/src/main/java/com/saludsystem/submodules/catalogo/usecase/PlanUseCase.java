package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlanUseCase implements PlanDao {

    private final PlanRepository planRepository;

    public PlanUseCase(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan update(UUID uuid, Plan plan) {
        return planRepository.update(uuid, plan);
    }

    @Override
    public void delete(UUID uuid) {
        planRepository.delete(uuid);
    }

    @Override
    public Plan getById(UUID uuid) {
        return planRepository.findById(uuid);
    }

    @Override
    public List<Plan> getAll(UUID hospitalId, int page, int rows) {
        return planRepository.findAll(hospitalId, page, rows);
    }
}
