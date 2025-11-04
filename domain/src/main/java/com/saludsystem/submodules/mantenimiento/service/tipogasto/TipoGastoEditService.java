package com.saludsystem.submodules.mantenimiento.service.tipogasto;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoGasto;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoGastoRepository;

public class TipoGastoEditService
{
	private final TipoGastoDao tipoGastoDao;
	private final TipoGastoRepository tipoGastoRepository;

	public TipoGastoEditService(TipoGastoDao tipoGastoDao, TipoGastoRepository tipoGastoRepository)
	{
		this.tipoGastoDao = tipoGastoDao;
		this.tipoGastoRepository = tipoGastoRepository;
	}

	public TipoGasto execute(UUID uuid, TipoGasto tipoGasto)
	{
		var currentTipoGasto = tipoGastoDao.getById(uuid);
		if (currentTipoGasto.getEstado() != null && currentTipoGasto.getEstado() == 0)
		{
			throw new IllegalStateException("El tipo de gasto ya se encuentra desactivado");
		}
		return tipoGastoRepository.update(uuid, tipoGasto);
	}
}
