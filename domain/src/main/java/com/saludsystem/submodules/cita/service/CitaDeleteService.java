package com.saludsystem.submodules.cita.service;

import java.util.UUID;

import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;

public class CitaDeleteService
{
	private final CitaRepository citaRepository;
	private final CitaDao citaDao;

	public CitaDeleteService(CitaRepository citaRepository, CitaDao citaDao)
	{
		this.citaRepository = citaRepository;
		this.citaDao = citaDao;
	}

	public void execute(UUID uuid)
	{
		var cita = citaDao.getById(uuid);
		if (cita.getEstado() != null)
		{
			throw new IllegalStateException("No se puede eliminar una cita ya desactivada");
		}
		citaRepository.delete(uuid);
	}
}