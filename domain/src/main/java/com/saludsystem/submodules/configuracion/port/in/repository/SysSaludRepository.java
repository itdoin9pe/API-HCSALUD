package com.saludsystem.submodules.configuracion.port.in.repository;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.SysSalud;

public interface SysSaludRepository
{
	SysSalud save(SysSalud sysSalud);

	SysSalud update(UUID uuid, SysSalud sysSalud);

	void delete(UUID uuid);
}