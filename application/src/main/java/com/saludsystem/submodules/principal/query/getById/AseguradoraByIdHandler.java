package com.saludsystem.submodules.principal.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.model.constant.AseguradoraConstant;
import com.saludsystem.submodules.principal.model.dtos.AseguradoraDTO;
import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;

@Component
public class AseguradoraByIdHandler
{
	private final AseguradoraDao aseguradoraDao;
	private final AseguradoraMapper aseguradoraMapper;

	public AseguradoraByIdHandler(AseguradoraDao aseguradoraDao, AseguradoraMapper aseguradoraMapper)
	{
		this.aseguradoraDao = aseguradoraDao;
		this.aseguradoraMapper = aseguradoraMapper;
	}

	public AseguradoraDTO execute(UUID uuid)
	{
		var aseguradora = aseguradoraDao.getById(uuid);
		if (aseguradora == null)
		{
			throw new IllegalArgumentException(AseguradoraConstant.INVALID_ID);
		}
		return aseguradoraMapper.toDto(aseguradora);
	}
}