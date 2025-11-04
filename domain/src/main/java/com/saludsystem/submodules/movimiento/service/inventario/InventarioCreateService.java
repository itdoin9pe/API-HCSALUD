package com.saludsystem.submodules.movimiento.service.inventario;

import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.movimiento.port.repository.InventarioRepository;

public class InventarioCreateService
{
	private final InventarioRepository inventarioRepository;

	public InventarioCreateService(InventarioRepository inventarioRepository)
	{
		this.inventarioRepository = inventarioRepository;
	}

	public Inventario execute(Inventario inventario)
	{
		return inventarioRepository.save(inventario);
	}
}