package com.saludsystem.submodules.operaciones.service.unidad;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.port.dao.UnidadDao;
import com.saludsystem.submodules.operaciones.port.repository.UnidadRepository;

public class UnidadDeleteService
{
	private final UnidadRepository unidadRepository;
	private final UnidadDao unidadDao;

	public UnidadDeleteService(UnidadRepository unidadRepository, UnidadDao unidadDao)
	{
		this.unidadRepository = unidadRepository;
		this.unidadDao = unidadDao;
	}

	public void execute(UUID uuid)
	{
		var unidad = unidadDao.getById(uuid);
		if (unidad.getEstado() != null && unidad.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar una unidad ya desactivada");
		}
		unidadRepository.delete(uuid);
	}
}
