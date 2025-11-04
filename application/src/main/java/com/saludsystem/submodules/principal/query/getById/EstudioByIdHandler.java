package com.saludsystem.submodules.principal.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.model.constant.EstudioConstant;
import com.saludsystem.submodules.principal.model.dtos.EstudioDTO;
import com.saludsystem.submodules.principal.port.dao.EstudioDao;

@Component
public class EstudioByIdHandler
{
	private final EstudioDao estudioDao;
	private final EstudioMapper estudioMapper;

	public EstudioByIdHandler(EstudioDao estudioDao, EstudioMapper estudioMapper)
	{
		this.estudioDao = estudioDao;
		this.estudioMapper = estudioMapper;
	}

	public EstudioDTO execute(UUID uuid)
	{
		var estudio = estudioDao.getById(uuid);
		if (estudio == null)
		{
			throw new IllegalArgumentException(EstudioConstant.INVALID_ID);
		}
		return estudioMapper.toDto(estudio);
	}
}