package com.saludsystem.submodules.movimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Compra;

public interface CompraRepository
{
	Compra save(Compra compra);

	Compra update(UUID uuid, Compra compra);

	void delete(UUID uuid);
}