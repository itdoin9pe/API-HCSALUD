package com.saludsystem.submodules.mantenimiento.service.tipogasto;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoGastoRepository;

public class TipoGastoDeleteService
{
	private final TipoGastoRepository tipoGastoRepository;
	private final TipoGastoDao tipoGastoDao;

	public TipoGastoDeleteService(TipoGastoRepository tipoGastoRepository, TipoGastoDao tipoGastoDao)
	{
		this.tipoGastoRepository = tipoGastoRepository;
		this.tipoGastoDao = tipoGastoDao;
	}

	public void execute(UUID uuid)
	{
		var tipoGasto = tipoGastoDao.getById(uuid);
		if (tipoGasto.getEstado() != null && tipoGasto.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede elimina un tipo de gasto ya desactivado");
		}
		tipoGastoRepository.delete(uuid);
	}
}
