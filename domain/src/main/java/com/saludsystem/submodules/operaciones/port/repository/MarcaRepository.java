package com.saludsystem.submodules.operaciones.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Marca;

public interface MarcaRepository
{
	Marca save(Marca marca);

	Marca update(UUID uuid, Marca marca);

	void delete(UUID uuid);
}