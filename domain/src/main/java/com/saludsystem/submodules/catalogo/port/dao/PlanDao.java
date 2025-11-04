package com.saludsystem.submodules.catalogo.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.response.ListResponse;

public interface PlanDao
{
	Plan getById(UUID uuid);

	ListResponse<Plan> getAll(UUID hospitalId, int page, int rows);

	List<Plan> getList();
}