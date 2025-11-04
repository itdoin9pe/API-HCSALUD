package com.saludsystem.submodules.paciente.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.Receta;
import com.saludsystem.submodules.response.ListResponse;

public interface RecetaDao
{
	Receta getById(UUID uuid);

	ListResponse<Receta> getAll(UUID hospitalId, int page, int rows);

	List<Receta> getList();
}
