package com.saludsystem.submodules.operaciones.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Marca;
import com.saludsystem.submodules.response.ListResponse;

public interface MarcaDao
{
	Marca getById(UUID uuid);

	ListResponse<Marca> getAll(UUID hospitalId, int page, int rows);

	List<Marca> getList();
}