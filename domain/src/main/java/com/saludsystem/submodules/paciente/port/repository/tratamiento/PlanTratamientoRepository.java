package com.saludsystem.submodules.paciente.port.repository.tratamiento;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;

public interface PlanTratamientoRepository
{
	PlanTratamiento save(PlanTratamiento planTratamiento);

	PlanTratamiento update(UUID uuid, PlanTratamiento planTratamiento);

	void delete(UUID uuid);
}