package com.saludsystem.submodules.operaciones.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.TipoMaterial;

public interface TipoMaterialRepository
{
	TipoMaterial save(TipoMaterial tipoMaterial);

	TipoMaterial update(UUID uuid, TipoMaterial tipoMaterial);

	void delete(UUID uuid);
}