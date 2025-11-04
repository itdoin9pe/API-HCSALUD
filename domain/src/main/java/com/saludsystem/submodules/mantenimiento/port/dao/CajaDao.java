package com.saludsystem.submodules.mantenimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Caja;
import com.saludsystem.submodules.response.ListResponse;

public interface CajaDao
{
	Caja getById(UUID uuid);

	ListResponse<Caja> getAll(UUID hospitalId, int page, int rows);

	List<Caja> getList();
}