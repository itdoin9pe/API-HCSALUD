package com.saludsystem.submodules.movimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Almacen;
import com.saludsystem.submodules.response.ListResponse;

public interface AlmacenDao
{
	Almacen getById(UUID uuid);

	ListResponse<Almacen> getAll(UUID hospitalId, int page, int rows);

	List<Almacen> getList();
}