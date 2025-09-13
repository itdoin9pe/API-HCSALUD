package com.saludsystem.submodules.operaciones.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.TipoMaterialMapper;
import com.saludsystem.submodules.operaciones.model.constant.TipoMaterialConstant;
import com.saludsystem.submodules.operaciones.model.dtos.TipoMaterialDTO;
import com.saludsystem.submodules.operaciones.port.dao.TipoMaterialDao;

@Component
public class TipoMaterialByIdHandler
{
	private final TipoMaterialDao tipoMaterialDao;
	private final TipoMaterialMapper tipoMaterialMapper;

	public TipoMaterialByIdHandler(TipoMaterialDao tipoMaterialDao, TipoMaterialMapper tipoMaterialMapper)
	{
		this.tipoMaterialDao = tipoMaterialDao;
		this.tipoMaterialMapper = tipoMaterialMapper;
	}

	public TipoMaterialDTO execute(UUID uuid)
	{
		var tipoMaterial = tipoMaterialDao.getById(uuid);
		if (tipoMaterial == null)
		{
			throw new IllegalArgumentException(TipoMaterialConstant.INVALID_ID);
		}
		return tipoMaterialMapper.toDto(tipoMaterial);
	}
}