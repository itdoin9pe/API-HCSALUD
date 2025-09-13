package com.saludsystem.submodules.mantenimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;

public interface TipoTarjetaRepository
{
	TipoTarjeta save(TipoTarjeta tipoTarjeta);

	TipoTarjeta update(UUID uuid, TipoTarjeta tipoTarjeta);

	void delete(UUID uuid);
}