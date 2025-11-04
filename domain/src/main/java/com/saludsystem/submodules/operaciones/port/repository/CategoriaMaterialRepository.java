package com.saludsystem.submodules.operaciones.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;

public interface CategoriaMaterialRepository
{
	CategoriaMaterial save(CategoriaMaterial categoriaMaterial);

	CategoriaMaterial update(UUID uuid, CategoriaMaterial categoriaMaterial);

	void delete(UUID uuid);
}