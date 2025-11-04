package com.saludsystem.submodules.configuracion.port.in.repository;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Rol;

public interface RolRepository
{
	Rol save(Rol rol);

	Rol update(UUID uuid, Rol rol);

	void delete(UUID uuid);
}