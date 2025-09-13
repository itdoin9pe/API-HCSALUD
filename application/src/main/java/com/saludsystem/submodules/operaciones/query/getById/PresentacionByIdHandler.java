package com.saludsystem.submodules.operaciones.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.PresentacionMapper;
import com.saludsystem.submodules.operaciones.model.constant.PresentacionConstant;
import com.saludsystem.submodules.operaciones.model.dtos.PresentacionDTO;
import com.saludsystem.submodules.operaciones.port.dao.PresentacionDao;

@Component
public class PresentacionByIdHandler
{
	private final PresentacionDao presentacionDao;
	private final PresentacionMapper presentacionMapper;

	public PresentacionByIdHandler(PresentacionDao presentacionDao, PresentacionMapper presentacionMapper)
	{
		this.presentacionDao = presentacionDao;
		this.presentacionMapper = presentacionMapper;
	}

	public PresentacionDTO execute(UUID uuid)
	{
		var presentacion = presentacionDao.getById(uuid);
		if (presentacion == null)
		{
			throw new IllegalArgumentException(PresentacionConstant.INVALID_ID);
		}
		return presentacionMapper.toDto(presentacion);
	}
}