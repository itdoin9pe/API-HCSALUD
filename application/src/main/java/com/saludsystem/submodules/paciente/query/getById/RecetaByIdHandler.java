package com.saludsystem.submodules.paciente.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.RecetaMapper;
import com.saludsystem.submodules.paciente.model.constant.RecetaConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.RecetaDTO;
import com.saludsystem.submodules.paciente.port.dao.RecetaDao;

@Component
public class RecetaByIdHandler
{
	private final RecetaDao recetaDao;
	private final RecetaMapper recetaMapper;

	public RecetaByIdHandler(RecetaDao recetaDao, RecetaMapper recetaMapper)
	{
		this.recetaDao = recetaDao;
		this.recetaMapper = recetaMapper;
	}

	public RecetaDTO execute(UUID uuid)
	{
		var receta = recetaDao.getById(uuid);
		if (receta == null)
		{
			throw new IllegalArgumentException(RecetaConstant.INVALID_ID);
		}
		return recetaMapper.toDto(receta);
	}
}