package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Especialidad;

public interface EspecialidadRepository
{
	Especialidad save(Especialidad especialidad);

	Especialidad update(UUID uuid, Especialidad especialidad);

	void delete(UUID uuid);
}