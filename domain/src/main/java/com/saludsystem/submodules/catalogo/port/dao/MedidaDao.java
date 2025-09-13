package com.saludsystem.submodules.catalogo.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.response.ListResponse;

public interface MedidaDao
{
	Medida getById(UUID uuid);

	ListResponse<Medida> getAll(UUID hospitalId, int page, int rows);

	List<Medida> getList();
}