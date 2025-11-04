package com.saludsystem.submodules.catalogo.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.response.ListResponse;

public interface CategoriaDao
{
	Categoria getById(UUID uuid);

	ListResponse<Categoria> getAll(UUID hospitalId, int page, int rows);

	List<Categoria> getList();
}