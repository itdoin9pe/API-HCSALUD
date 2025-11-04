package com.saludsystem.submodules.configuracion.query.getAll;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.SedeMapper;
import com.saludsystem.submodules.configuracion.model.constant.SedeConstant;
import com.saludsystem.submodules.configuracion.model.dtos.SedeDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.SedeDao;

@Component
public class SedeByIdHandler
{
	private final SedeDao sedeDao;
	private final SedeMapper sedeMapper;

	public SedeByIdHandler(SedeDao sedeDao, SedeMapper sedeMapper)
	{
		this.sedeDao = sedeDao;
		this.sedeMapper = sedeMapper;
	}

	public SedeDTO execute(UUID uuid)
	{
		var sede = sedeDao.getById(uuid);
		if (sede == null)
		{
			throw new IllegalArgumentException(SedeConstant.ID_NOT_FOUND);
		}
		return sedeMapper.toDto(sede);
	}
}