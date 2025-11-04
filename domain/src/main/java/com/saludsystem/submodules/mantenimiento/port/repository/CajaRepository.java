package com.saludsystem.submodules.mantenimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Caja;

public interface CajaRepository
{
	Caja save(Caja caja);

	Caja update(UUID uuid, Caja caja);

	void delete(UUID uuid);
}