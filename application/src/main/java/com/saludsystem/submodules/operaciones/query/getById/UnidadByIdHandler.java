package com.saludsystem.submodules.operaciones.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.UnidadMapper;
import com.saludsystem.submodules.operaciones.model.constant.UnidadConstant;
import com.saludsystem.submodules.operaciones.model.dtos.UnidadDTO;
import com.saludsystem.submodules.operaciones.port.dao.UnidadDao;

@Component
public class UnidadByIdHandler
{
	private final UnidadDao unidadDao;
	private final UnidadMapper unidadMapper;

	public UnidadByIdHandler(UnidadDao unidadDao, UnidadMapper unidadMapper)
	{
		this.unidadDao = unidadDao;
		this.unidadMapper = unidadMapper;
	}

	public UnidadDTO execute(UUID uuid)
	{
		var unidad = unidadDao.getById(uuid);
		if (unidad == null)
		{
			throw new IllegalArgumentException(UnidadConstant.INVALID_ID);
		}
		return unidadMapper.toDto(unidad);
	}
}