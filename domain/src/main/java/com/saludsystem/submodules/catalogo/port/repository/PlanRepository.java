package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Plan;

import java.util.UUID;

public interface PlanRepository {
    Plan save(Plan plan);
    Plan update(UUID uuid, Plan plan);
    void delete(UUID uuid);
}