package com.saludsystem.submodules.movimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.VentaDetalle;

public interface VentaDetalleRepository
{
	VentaDetalle save(VentaDetalle ventaDetalle);

	VentaDetalle update(UUID uuid, VentaDetalle ventaDetalle);

	void delete(UUID uuid);
}