package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Medida;

public interface MedidaRepository
{
	Medida save(Medida medida);

	Medida update(UUID uuid, Medida medida);

	void delete(UUID uuid);
}