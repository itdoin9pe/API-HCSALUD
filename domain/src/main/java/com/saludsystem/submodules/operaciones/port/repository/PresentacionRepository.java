package com.saludsystem.submodules.operaciones.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Presentacion;

public interface PresentacionRepository
{
	Presentacion save(Presentacion presentacion);

	Presentacion update(UUID uuid, Presentacion presentacion);

	void delete(UUID uuid);
}