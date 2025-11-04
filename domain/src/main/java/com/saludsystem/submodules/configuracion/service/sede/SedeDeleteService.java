package com.saludsystem.submodules.configuracion.service.sede;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.port.in.dao.SedeDao;
import com.saludsystem.submodules.configuracion.port.in.repository.SedeRepository;

public class SedeDeleteService
{
	private final SedeRepository sedeRepository;
	private final SedeDao sedeDao;

	public SedeDeleteService(SedeRepository sedeRepository, SedeDao sedeDao)
	{
		this.sedeRepository = sedeRepository;
		this.sedeDao = sedeDao;
	}

	public void execute(UUID uuid)
	{
		var sede = sedeDao.getById(uuid);
		if (sede.getEstado() != null && sede.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar una sede ya desactivada");
		}
		sedeRepository.delete(uuid);
	}
}