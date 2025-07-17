package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;
import com.saludsystem.submodules.core.catalogo.adapter.entity.PlanEntity;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.PlanJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.PlanDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PlanMysqlDao implements PlanRepository {

    private final PlanJpaRepository planJpaRepository;

    public PlanMysqlDao(PlanJpaRepository planJpaRepository) {
        this.planJpaRepository = planJpaRepository;
    }

    @Override
    public Plan save(Plan plan) {
        PlanEntity entity = PlanDboMapper.toEntity(plan);
        return PlanDboMapper.toDomain(planJpaRepository.save(entity));
    }

    @Override
    public Plan update(UUID uuid, Plan plan) {
        plan.setId(uuid);
        PlanEntity entity = PlanDboMapper.toEntity(plan);
        return PlanDboMapper.toDomain(planJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
        planJpaRepository.deleteById(uuid);
    }

    @Override
    public Plan findById(UUID uuid) {
        return planJpaRepository.findById(uuid).map(PlanDboMapper::toDomain).orElse(null);
    }

    @Override
    public List<Plan> findAll(UUID hospitalId, int page, int rows) {
        return planJpaRepository.findAllByHospital_HospitalId(hospitalId, PageRequest.of(page, rows))
                .stream().map(PlanDboMapper::toDomain).toList();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return planJpaRepository.countByHospital_HospitalId(hospitalId);
    }
}