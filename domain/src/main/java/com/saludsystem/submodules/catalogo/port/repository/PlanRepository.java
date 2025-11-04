package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Plan;

public interface PlanRepository
{
	Plan save(Plan plan);

	Plan update(UUID uuid, Plan plan);

	void delete(UUID uuid);
}