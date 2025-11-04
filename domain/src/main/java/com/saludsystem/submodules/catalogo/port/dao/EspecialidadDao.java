package com.saludsystem.submodules.catalogo.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.response.ListResponse;

public interface EspecialidadDao
{
	Especialidad getById(UUID uuid);

	ListResponse<Especialidad> getAll(UUID hospitalId, int page, int rows);

	List<Especialidad> getList();
}