package com.saludsystem.submodules.catalogo.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.constant.ApoderadoConstant;
import com.saludsystem.submodules.catalogo.model.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;

@Component
public class ApoderadoByIdHandler
{
	private final ApoderadoDao apoderadoDao;
	private final ApoderadoMapper apoderadoMapper;

	public ApoderadoByIdHandler(ApoderadoDao apoderadoDao, ApoderadoMapper apoderadoMapper)
	{
		this.apoderadoDao = apoderadoDao;
		this.apoderadoMapper = apoderadoMapper;
	}

	public ApoderadoDTO execute(UUID uuid)
	{
		var apoderado = apoderadoDao.getById(uuid);
		if (apoderado == null)
		{
			throw new IllegalArgumentException(ApoderadoConstant.ID_INVALID);
		}
		return apoderadoMapper.toDto(apoderado);
	}
}