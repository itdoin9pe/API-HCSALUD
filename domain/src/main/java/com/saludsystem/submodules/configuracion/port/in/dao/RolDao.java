package com.saludsystem.submodules.configuracion.port.in.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Rol;
import com.saludsystem.submodules.response.ListResponse;

public interface RolDao
{
	Rol getById(UUID uuid);

	ListResponse<Rol> getAll(UUID hospitalId, int page, int rows);

	List<Rol> getList();
}
