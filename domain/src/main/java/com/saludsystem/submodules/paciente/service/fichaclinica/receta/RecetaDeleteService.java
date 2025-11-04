package com.saludsystem.submodules.paciente.service.fichaclinica.receta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.port.dao.RecetaDao;
import com.saludsystem.submodules.paciente.port.repository.RecetaRepository;

public class RecetaDeleteService
{
	private final RecetaRepository recetaRepository;
	private final RecetaDao recetaDao;

	public RecetaDeleteService(RecetaRepository recetaRepository, RecetaDao recetaDao)
	{
		this.recetaRepository = recetaRepository;
		this.recetaDao = recetaDao;
	}

	public void execute(UUID uuid)
	{
		var receta = recetaDao.getById(uuid);
		if (receta.getEstado() != null && receta.getEstado() == 0)
		{
			throw new IllegalStateException("No se pede eliminar una receta inoperativa");
		}
		recetaRepository.delete(uuid);
	}
}
