package com.saludsystem.submodules.mantenimiento.service.moneda;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.MonedaRepository;

public class MonedaDeleteService
{
	private final MonedaRepository monedaRepository;
	private final MonedaDao monedaDao;

	public MonedaDeleteService(MonedaRepository monedaRepository, MonedaDao monedaDao)
	{
		this.monedaRepository = monedaRepository;
		this.monedaDao = monedaDao;
	}

	public void execute(UUID uuid)
	{
		var moneda = monedaDao.getById(uuid);
		if (moneda.getEstado() != null && moneda.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un tipo de moneda ya desactivada");
		}
		monedaRepository.delete(uuid);
	}
}
