package com.saludsystem.submodules.configuracion.port.in.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.response.ListResponse;

public interface UserDao
{
	Usuario getById(UUID uuid);

	ListResponse<Usuario> getAll(UUID hospitalId, int page, int rows);

	List<Usuario> getList();
}
