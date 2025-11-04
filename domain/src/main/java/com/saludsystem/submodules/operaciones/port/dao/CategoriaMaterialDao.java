package com.saludsystem.submodules.operaciones.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.response.ListResponse;

public interface CategoriaMaterialDao
{
	CategoriaMaterial getById(UUID uuid);

	ListResponse<CategoriaMaterial> getAll(UUID hospitalId, int page, int rows);

	List<CategoriaMaterial> getList();
}