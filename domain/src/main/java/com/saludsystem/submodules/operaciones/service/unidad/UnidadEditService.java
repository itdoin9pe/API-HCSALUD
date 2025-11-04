package com.saludsystem.submodules.operaciones.service.unidad;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Unidad;
import com.saludsystem.submodules.operaciones.port.dao.UnidadDao;
import com.saludsystem.submodules.operaciones.port.repository.UnidadRepository;

public class UnidadEditService
{
	private final UnidadDao unidadDao;
	private final UnidadRepository unidadRepository;

	public UnidadEditService(UnidadDao unidadDao, UnidadRepository unidadRepository)
	{
		this.unidadDao = unidadDao;
		this.unidadRepository = unidadRepository;
	}

	public Unidad execute(UUID uuid, Unidad unidad)
	{
		var currentUnidad = unidadDao.getById(uuid);
		if (currentUnidad.getEstado() != null && currentUnidad.getEstado() == 0)
		{
			throw new IllegalStateException("La unidad ya se encuentra desactivada");
		}
		return unidadRepository.update(uuid, unidad);
	}
}
