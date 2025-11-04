package com.saludsystem.submodules.operaciones.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Producto;

public interface ProductoRepository
{
	Producto save(Producto producto);

	Producto update(UUID uuid, Producto producto);

	void delete(UUID uuid);
}
