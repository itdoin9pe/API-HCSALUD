package com.saludsystem.submodules.movimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Inventario;

public interface InventarioRepository
{
	Inventario save(Inventario inventario);

	Inventario update(UUID uuid, Inventario inventario);

	void delete(UUID uuid);
}