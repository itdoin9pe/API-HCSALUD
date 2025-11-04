package com.saludsystem.submodules.principal.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.principal.model.Sucursal;
import com.saludsystem.submodules.response.ListResponse;

public interface SucursalDao
{
	Sucursal getById(UUID uuid);

	ListResponse<Sucursal> getAll(UUID hospitalId, int page, int rows);

	List<Sucursal> getList();
}
