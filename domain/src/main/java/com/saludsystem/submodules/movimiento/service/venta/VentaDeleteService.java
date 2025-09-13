package com.saludsystem.submodules.movimiento.service.venta;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.port.dao.VentaDao;
import com.saludsystem.submodules.movimiento.port.repository.VentaRepository;

public class VentaDeleteService
{
	private final VentaRepository ventaRepository;
	private final VentaDao ventaDao;

	public VentaDeleteService(VentaRepository ventaRepository, VentaDao ventaDao)
	{
		this.ventaRepository = ventaRepository;
		this.ventaDao = ventaDao;
	}

	public void execute(UUID uuid)
	{
		var venta = ventaDao.getById(uuid);
		if (venta.getEstado() != null && venta.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar una venta desactivada");
		}
		ventaRepository.delete(uuid);
	}
}
