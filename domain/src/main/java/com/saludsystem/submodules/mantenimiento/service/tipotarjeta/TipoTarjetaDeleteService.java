package com.saludsystem.submodules.mantenimiento.service.tipotarjeta;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoTarjetaRepository;

public class TipoTarjetaDeleteService
{
	private final TipoTarjetaRepository tipoTarjetaRepository;
	private final TipoTarjetaDao tipoTarjetaDao;

	public TipoTarjetaDeleteService(TipoTarjetaRepository tipoTarjetaRepository, TipoTarjetaDao tipoTarjetaDao)
	{
		this.tipoTarjetaRepository = tipoTarjetaRepository;
		this.tipoTarjetaDao = tipoTarjetaDao;
	}

	public void execute(UUID uuid)
	{
		var tipoTarjeta = tipoTarjetaDao.getById(uuid);
		if (tipoTarjeta.getEstado() != null && tipoTarjeta.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar el tipo de tajeta ya desactivada");
		}
		tipoTarjetaRepository.delete(uuid);
	}
}
