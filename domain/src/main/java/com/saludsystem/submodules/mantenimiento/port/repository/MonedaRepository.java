package com.saludsystem.submodules.mantenimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Moneda;

public interface MonedaRepository
{
	Moneda save(Moneda moneda);

	Moneda update(UUID uuid, Moneda moneda);

	void delete(UUID uuid);
}