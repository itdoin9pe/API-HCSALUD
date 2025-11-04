package com.saludsystem.submodules.mantenimiento.service.tipopago;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoPagoRepository;

public class TipoPagoEditService
{
	private final TipoPagoDao tipoPagoDao;
	private final TipoPagoRepository tipoPagoRepository;

	public TipoPagoEditService(TipoPagoDao tipoPagoDao, TipoPagoRepository tipoPagoRepository)
	{
		this.tipoPagoDao = tipoPagoDao;
		this.tipoPagoRepository = tipoPagoRepository;
	}

	public TipoPago execute(UUID uuid, TipoPago tipoPago)
	{
		var currentTipoPago = tipoPagoDao.getById(uuid);
		if (currentTipoPago.getEstado() != null && currentTipoPago.getEstado() == 0)
		{
			throw new IllegalStateException("El tipo de pago ya se encuentra desactivado");
		}
		return tipoPagoRepository.update(uuid, tipoPago);
	}
}
