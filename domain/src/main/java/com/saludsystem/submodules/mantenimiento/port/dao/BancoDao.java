package com.saludsystem.submodules.mantenimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.response.ListResponse;

public interface BancoDao
{
	Banco getById(UUID uuid);

	ListResponse<Banco> getAll(UUID hospitalId, int page, int rows);

	List<Banco> getList();
}