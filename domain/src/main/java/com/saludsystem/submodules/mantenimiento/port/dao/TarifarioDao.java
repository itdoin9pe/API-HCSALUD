package com.saludsystem.submodules.mantenimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.response.ListResponse;

public interface TarifarioDao
{
	Tarifario getById(UUID uuid);

	ListResponse<Tarifario> getAll(UUID hospitalId, int page, int rows);

	List<Tarifario> getList();
}