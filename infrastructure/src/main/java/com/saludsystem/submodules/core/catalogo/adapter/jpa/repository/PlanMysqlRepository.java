package com.saludsystem.submodules.core.catalogo.adapter.jpa.repository;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.catalogo.adapter.entity.PlanEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.PlanJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.PlanDboMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanMysqlRepository implements PlanRepository {

    private final PlanJpaRepository planJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public PlanMysqlRepository(PlanJpaRepository planJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.planJpaRepository = planJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Plan save(Plan plan) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        PlanEntity entity = PlanDboMapper.toEntity(plan, userId, hospitalId);
        return PlanDboMapper.toDomain(planJpaRepository.save(entity));
    }

    @Override
    public Plan update(UUID uuid, Plan plan) {
        UUID userId = authenticateUserPort.getUserId();
        UUID hospitalId = authenticateUserPort.getHospitalId();
        PlanEntity entity = PlanDboMapper.toEntity(plan, userId, hospitalId);
        return PlanDboMapper.toDomain(planJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        planJpaRepository.deleteById(uuid);
    }
}
