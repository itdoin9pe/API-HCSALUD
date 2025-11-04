package com.saludsystem.submodules.operaciones.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.model.constant.CategoriaMaterialConstant;
import com.saludsystem.submodules.operaciones.model.dtos.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;

@Component
public class CategoriaMaterialByIdHandler
{
	private final CategoriaMaterialDao categoriaMaterialDao;
	private final CategoriaMaterialMapper categoriaMaterialMapper;

	public CategoriaMaterialByIdHandler(
		CategoriaMaterialDao categoriaMaterialDao,
		CategoriaMaterialMapper categoriaMaterialMapper)
	{
		this.categoriaMaterialDao = categoriaMaterialDao;
		this.categoriaMaterialMapper = categoriaMaterialMapper;
	}

	public CategoriaMatDTO execute(UUID uuid)
	{
		var catMaterial = categoriaMaterialDao.getById(uuid);
		if (catMaterial == null)
		{
			throw new IllegalArgumentException(CategoriaMaterialConstant.INVALID_ID);
		}
		return categoriaMaterialMapper.toDto(catMaterial);
	}
}