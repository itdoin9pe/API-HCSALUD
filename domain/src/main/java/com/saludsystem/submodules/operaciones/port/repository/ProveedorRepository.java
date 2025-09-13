package com.saludsystem.submodules.operaciones.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Proveedor;

public interface ProveedorRepository
{
	Proveedor save(Proveedor proveedor);

	Proveedor update(UUID uuid, Proveedor proveedor);

	void delete(UUID uuid);
}