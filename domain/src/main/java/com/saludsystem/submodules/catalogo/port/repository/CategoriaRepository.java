package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Categoria;

public interface CategoriaRepository
{
	Categoria save(Categoria categoria);

	Categoria update(UUID uuid, Categoria categoria);

	void delete(UUID uuid);
}