package com.saludsystem.submodules.mantenimiento.service.tipopago;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoPagoRepository;

public class TipoPagoDeleteService
{
	private final TipoPagoRepository tipoPagoRepository;
	private final TipoPagoDao tipoGastoDao;

	public TipoPagoDeleteService(TipoPagoRepository tipoPagoRepository, TipoPagoDao tipoGastoDao)
	{
		this.tipoPagoRepository = tipoPagoRepository;
		this.tipoGastoDao = tipoGastoDao;
	}

	public void execute(UUID uuid)
	{
		var tipoPago = tipoGastoDao.getById(uuid);
		if (tipoPago.getEstado() != null && tipoPago.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar el tipo de pago ya desactivado");
		}
		tipoPagoRepository.delete(uuid);
	}
}
