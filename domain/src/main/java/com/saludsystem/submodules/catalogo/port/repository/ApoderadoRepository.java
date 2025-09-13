package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Apoderado;

public interface ApoderadoRepository
{
	Apoderado save(Apoderado apoderado);

	Apoderado update(UUID uuid, Apoderado apoderado);

	void delete(UUID uuid);
}