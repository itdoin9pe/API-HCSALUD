package com.saludsystem.submodules.mantenimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.response.ListResponse;

public interface MonedaDao
{
	Moneda getById(UUID uuid);

	ListResponse<Moneda> getAll(UUID hospitalId, int page, int rows);

	List<Moneda> getList();
}