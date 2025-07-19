package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PlanDao {
    Plan getById(UUID uuid);
    ListResponse<Plan> getAll(UUID hospitalId, int page, int rows);
    List<Plan> getList();
}