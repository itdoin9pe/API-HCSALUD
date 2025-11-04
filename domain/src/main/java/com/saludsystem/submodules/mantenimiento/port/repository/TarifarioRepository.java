package com.saludsystem.submodules.mantenimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Tarifario;

public interface TarifarioRepository
{
	Tarifario save(Tarifario tarifario);

	Tarifario update(UUID uuid, Tarifario tarifario);

	void delete(UUID uuid);
}