package com.saludsystem.domain.catalogo.port.out.repository;

import com.saludsystem.domain.catalogo.model.Plan;

import java.util.List;
import java.util.UUID;

public interface PlanRepositoryPort {
    Plan save(Plan plan);
    Plan update(UUID uuid, Plan plan);
    void delete(UUID uuid);
    Plan findById(UUID uuid);
    List<Plan> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}