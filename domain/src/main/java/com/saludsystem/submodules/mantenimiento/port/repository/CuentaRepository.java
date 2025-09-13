package com.saludsystem.submodules.mantenimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Cuenta;

public interface CuentaRepository
{
	Cuenta save(Cuenta cuenta);

	Cuenta update(UUID uuid, Cuenta cuenta);

	void delete(UUID uuid);
}