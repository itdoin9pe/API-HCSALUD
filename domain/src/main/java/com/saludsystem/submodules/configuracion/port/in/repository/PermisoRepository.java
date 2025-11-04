package com.saludsystem.submodules.configuracion.port.in.repository;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Permiso;

public interface PermisoRepository
{
	Permiso save(Permiso permiso);

	Permiso update(UUID uuid, Permiso permiso);

	void delete(UUID uuid);
}