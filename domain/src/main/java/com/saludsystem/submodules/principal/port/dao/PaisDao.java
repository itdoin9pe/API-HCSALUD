package com.saludsystem.submodules.principal.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.response.ListResponse;

public interface PaisDao
{
	Pais getById(Integer id);

	ListResponse<Pais> getAll(UUID hospitalId, int page, int rows);

	List<Pais> getList();
}