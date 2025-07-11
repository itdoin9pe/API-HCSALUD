package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.domain.catalogo.model.Plan;

import java.util.List;
import java.util.UUID;

public interface PlanService {
    Plan save(Plan plan);
    Plan update(UUID uuid, Plan plan);
    void delete(UUID uuid);
    Plan getById(UUID uuid);
    List<Plan> getAll(UUID hospitalId, int page, int rows);
}