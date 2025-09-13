package com.saludsystem.submodules.operaciones.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Unidad;

public interface UnidadRepository
{
	Unidad save(Unidad unidad);

	Unidad update(UUID uuid, Unidad unidad);

	void delete(UUID uuid);
}