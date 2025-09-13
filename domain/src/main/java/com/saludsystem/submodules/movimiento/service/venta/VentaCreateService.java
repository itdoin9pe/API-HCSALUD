package com.saludsystem.submodules.movimiento.service.venta;

import com.saludsystem.submodules.movimiento.model.Venta;
import com.saludsystem.submodules.movimiento.port.repository.VentaRepository;

public class VentaCreateService
{
	private final VentaRepository ventaRepository;

	public VentaCreateService(VentaRepository ventaRepository)
	{
		this.ventaRepository = ventaRepository;
	}

	public Venta execute(Venta venta)
	{
		return ventaRepository.save(venta);
	}
}
