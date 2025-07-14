package com.saludsystem.infrastructure.adapter.repository.catalogo;

import com.saludsystem.domain.catalogo.model.Plan;
import com.saludsystem.domain.catalogo.port.out.repository.PlanRepositoryPort;
import com.saludsystem.infrastructure.adapter.entity.catalogo.PlanEntity;
import com.saludsystem.infrastructure.adapter.jparepository.catalogo.PlanJpaRepository;
import com.saludsystem.infrastructure.adapter.mapper.catalogo.PlanDboMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PlanRepositoryAdapter implements PlanRepositoryPort {

    private final PlanJpaRepository planJpaRepository;

    public PlanRepositoryAdapter(PlanJpaRepository planJpaRepository) {
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