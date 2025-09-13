package com.saludsystem.submodules.mantenimiento.service.tipopago;

import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoPagoRepository;

public class TipoPagoCreateService
{
	private final TipoPagoRepository tipoPagoRepository;

	public TipoPagoCreateService(TipoPagoRepository tipoPagoRepository)
	{
		this.tipoPagoRepository = tipoPagoRepository;
	}

	public TipoPago execute(TipoPago tipoPago)
	{
		return tipoPagoRepository.save(tipoPago);
	}
}
