package com.saludsystem.submodules.paciente.port.repository.evolucion;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;

public interface EvolucionRepository
{
	Evolucion save(Evolucion evolucion);

	Evolucion update(UUID uuid, Evolucion evolucion);

	void delete(UUID uuid);
}