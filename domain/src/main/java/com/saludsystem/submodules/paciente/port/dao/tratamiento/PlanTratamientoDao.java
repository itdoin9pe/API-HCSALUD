package com.saludsystem.submodules.paciente.port.dao.tratamiento;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;
import com.saludsystem.submodules.response.ListResponse;

public interface PlanTratamientoDao
{
	PlanTratamiento getById(UUID uuid);

	ListResponse<PlanTratamiento> getAll(UUID hospitalId, int page, int rows);

	List<PlanTratamiento> getList();
}