package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Alergia;

public interface AlergiaRepository
{
	Alergia save(Alergia alergia);

	Alergia update(UUID id, Alergia alergia);

	void delete(UUID id);
}