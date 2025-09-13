package com.saludsystem.submodules.movimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Almacen;

public interface AlmacenRepository
{
	Almacen save(Almacen almacen);

	Almacen update(UUID uuid, Almacen almacen);

	void delete(UUID uuid);
}