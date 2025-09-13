package com.saludsystem.submodules.movimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Venta;

public interface VentaRepository
{
	Venta save(Venta venta);

	Venta update(UUID uuid, Venta venta);

	void delete(UUID uuid);
}