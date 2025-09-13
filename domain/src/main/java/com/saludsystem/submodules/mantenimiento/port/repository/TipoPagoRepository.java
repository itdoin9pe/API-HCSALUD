package com.saludsystem.submodules.mantenimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoPago;

public interface TipoPagoRepository
{
	TipoPago save(TipoPago tipoPago);

	TipoPago update(UUID uuid, TipoPago tipoPago);

	void delete(UUID uuid);
}