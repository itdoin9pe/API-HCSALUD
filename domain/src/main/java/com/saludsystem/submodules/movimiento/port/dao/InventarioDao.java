package com.saludsystem.submodules.movimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.response.ListResponse;

public interface InventarioDao
{
	Inventario getById(UUID uuid);

	ListResponse<Inventario> getAll(UUID hospitalId, int page, int rows);

	List<Inventario> getList();
}