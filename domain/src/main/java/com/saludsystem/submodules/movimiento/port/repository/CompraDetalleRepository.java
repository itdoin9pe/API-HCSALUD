package com.saludsystem.submodules.movimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.CompraDetalle;

public interface CompraDetalleRepository
{
	CompraDetalle save(CompraDetalle compraDetalle);

	CompraDetalle update(UUID uuid, CompraDetalle compraDetalle);

	void delete(UUID uuid);
}