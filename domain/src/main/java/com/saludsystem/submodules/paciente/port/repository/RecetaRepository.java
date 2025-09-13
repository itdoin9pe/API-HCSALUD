package com.saludsystem.submodules.paciente.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.Receta;

public interface RecetaRepository
{
	Receta save(Receta receta);

	Receta update(UUID uuid, Receta receta);

	void delete(UUID uuid);
}