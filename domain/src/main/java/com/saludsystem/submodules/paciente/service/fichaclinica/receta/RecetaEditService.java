package com.saludsystem.submodules.paciente.service.fichaclinica.receta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.RecetaConstant;
import com.saludsystem.submodules.paciente.model.entity.Receta;
import com.saludsystem.submodules.paciente.port.dao.RecetaDao;
import com.saludsystem.submodules.paciente.port.repository.RecetaRepository;

public class RecetaEditService
{
	private final RecetaDao recetaDao;
	private final RecetaRepository recetaRepository;

	public RecetaEditService(RecetaDao recetaDao, RecetaRepository recetaRepository)
	{
		this.recetaDao = recetaDao;
		this.recetaRepository = recetaRepository;
	}

	public Receta execute(UUID uuid, Receta receta)
	{
		var curremtReceta = recetaDao.getById(uuid);
		if (curremtReceta == null)
		{
			throw new IllegalArgumentException(RecetaConstant.ID_NOT_FOUND);
		}
		if (curremtReceta.getEstado() != null && curremtReceta.getEstado() == 0)
		{
			throw new IllegalStateException("La receta se encuentra inoperativa");
		}
		return recetaRepository.update(uuid, receta);
	}
}
