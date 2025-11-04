package com.saludsystem.submodules.movimiento.service.venta;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Venta;
import com.saludsystem.submodules.movimiento.model.constant.VentaConstant;
import com.saludsystem.submodules.movimiento.port.dao.VentaDao;
import com.saludsystem.submodules.movimiento.port.repository.VentaRepository;

public class VentaEditService
{
	private final VentaDao ventaDao;
	private final VentaRepository ventaRepository;

	public VentaEditService(VentaDao ventaDao, VentaRepository ventaRepository)
	{
		this.ventaDao = ventaDao;
		this.ventaRepository = ventaRepository;
	}

	public Venta execute(UUID uuid, Venta venta)
	{
		var currentVenta = ventaDao.getById(uuid);
		if (currentVenta == null)
		{
			throw new IllegalArgumentException(VentaConstant.INVALID_ID);
		}
		if (currentVenta.getEstado() != null && currentVenta.getEstado() == 0)
		{
			throw new IllegalStateException("La venta se encuentra desactivada");
		}
		return ventaRepository.update(uuid, venta);
	}
}
