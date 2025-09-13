package com.saludsystem.submodules.principal.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.principal.model.Aseguradora;

public interface AseguradoraRepository
{
	Aseguradora save(Aseguradora aseguradora);

	Aseguradora update(UUID uuid, Aseguradora aseguradora);

	void delete(UUID uuid);
}