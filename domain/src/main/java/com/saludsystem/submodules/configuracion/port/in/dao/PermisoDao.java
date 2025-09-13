package com.saludsystem.submodules.configuracion.port.in.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.response.ListResponse;

public interface PermisoDao
{
	Permiso getById(UUID uuid);

	ListResponse<Permiso> getAll(UUID hospitalId, int page, int rows);

	List<Permiso> getList();
}
