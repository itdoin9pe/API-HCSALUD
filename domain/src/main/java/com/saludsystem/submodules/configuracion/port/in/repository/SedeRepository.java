package com.saludsystem.submodules.configuracion.port.in.repository;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Sede;

public interface SedeRepository
{
	Sede save(Sede sede);

	Sede update(UUID uuid, Sede sede);

	void delete(UUID uuid);
}