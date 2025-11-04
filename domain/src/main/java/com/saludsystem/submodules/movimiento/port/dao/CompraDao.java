package com.saludsystem.submodules.movimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Compra;
import com.saludsystem.submodules.response.ListResponse;

public interface CompraDao
{
	Compra getById(UUID uuid);

	ListResponse<Compra> getAll(UUID hospitalId, int page, int rows);

	List<Compra> getList();
}