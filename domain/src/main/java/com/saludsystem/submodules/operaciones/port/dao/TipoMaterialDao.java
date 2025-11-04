package com.saludsystem.submodules.operaciones.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.TipoMaterial;
import com.saludsystem.submodules.response.ListResponse;

public interface TipoMaterialDao
{
	TipoMaterial getById(UUID uuid);

	ListResponse<TipoMaterial> getAll(UUID hospitalId, int page, int rows);

	List<TipoMaterial> getList();
}