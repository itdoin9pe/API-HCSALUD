package com.saludsystem.submodules.principal.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.principal.model.Estudio;

public interface EstudioRepository
{
	Estudio save(Estudio estudio);

	Estudio update(UUID uuid, Estudio estudio);

	void delete(UUID uuid);
}