package com.saludsystem.submodules.movimiento.service.compradetalle;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;

public class CompraDetalleDeleteService
{
	private final CompraDetalleRepository compraDetalleRepository;
	private final CompraDetalleDao compraDetalleDao;

	public CompraDetalleDeleteService(
		CompraDetalleRepository compraDetalleRepository,
		CompraDetalleDao compraDetalleDao)
	{
		this.compraDetalleRepository = compraDetalleRepository;
		this.compraDetalleDao = compraDetalleDao;
	}

	public void execute(UUID uuid)
	{
		var compraDetalle = compraDetalleDao.getById(uuid);
		if (compraDetalle.getCantidad() != null && compraDetalle.getCantidad().equals(0))
		{
			throw new IllegalStateException("No se puede eliminar un detalle ");
		}
		compraDetalleRepository.delete(uuid);
	}
}
