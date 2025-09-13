package com.saludsystem.submodules.principal.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.principal.model.Aseguradora;
import com.saludsystem.submodules.response.ListResponse;

public interface AseguradoraDao
{
	Aseguradora getById(UUID uuid);

	ListResponse<Aseguradora> getAll(UUID hospitalId, int page, int rows);

	List<Aseguradora> getList();
}