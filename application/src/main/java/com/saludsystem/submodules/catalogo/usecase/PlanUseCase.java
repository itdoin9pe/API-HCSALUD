package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.in.service.PlanService;
import com.saludsystem.submodules.catalogo.port.out.repository.PlanRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlanUseCase implements PlanService {

    private final PlanRepositoryPort planRepositoryPort;

    public PlanUseCase(PlanRepositoryPort planRepositoryPort) {
        this.planRepositoryPort = planRepositoryPort;
    }

    @Override
    public Plan save(Plan plan) {
        return planRepositoryPort.save(plan);
    }

    @Override
    public Plan update(UUID uuid, Plan plan) {
        return planRepositoryPort.update(uuid, plan);
    }

    @Override
    public void delete(UUID uuid) {
        planRepositoryPort.delete(uuid);
    }

    @Override
    public Plan getById(UUID uuid) {
        return planRepositoryPort.findById(uuid);
    }

    @Override
    public List<Plan> getAll(UUID hospitalId, int page, int rows) {
        return planRepositoryPort.findAll(hospitalId, page, rows);
    }
}
