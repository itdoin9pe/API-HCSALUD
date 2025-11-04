package com.saludsystem.submodules.operaciones.service.marca;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;
import com.saludsystem.submodules.operaciones.port.repository.MarcaRepository;

public class MarcaDeleteService
{
	private final MarcaRepository marcaRepository;
	private final MarcaDao marcaDao;

	public MarcaDeleteService(MarcaRepository marcaRepository, MarcaDao marcaDao)
	{
		this.marcaRepository = marcaRepository;
		this.marcaDao = marcaDao;
	}

	public void execute(UUID uuid)
	{
		var marca = marcaDao.getById(uuid);
		if (marca.getEstado() != null && marca.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar una marca ya desactivada");
		}
		marcaRepository.delete(uuid);
	}
}
