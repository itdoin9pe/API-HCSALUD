package com.saludsystem.submodules.mantenimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoGasto;

public interface TipoGastoRepository
{
	TipoGasto save(TipoGasto tipoGasto);

	TipoGasto update(UUID uuid, TipoGasto tipoGasto);

	void delete(UUID uuid);
}