package com.saludsystem.submodules.configuracion.query.getAll;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.PermisoMapper;
import com.saludsystem.submodules.configuracion.model.constant.PermisoConstant;
import com.saludsystem.submodules.configuracion.model.dtos.PermisoDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.PermisoDao;

@Component
public class PermisoByIdHandler
{
	private final PermisoDao permisoDao;
	private final PermisoMapper permisoMapper;

	public PermisoByIdHandler(PermisoDao permisoDao, PermisoMapper permisoMapper)
	{
		this.permisoDao = permisoDao;
		this.permisoMapper = permisoMapper;
	}

	public PermisoDTO execute(UUID uuid)
	{
		var permiso = permisoDao.getById(uuid);
		if (permiso == null)
		{
			throw new IllegalArgumentException(PermisoConstant.INVALID_ID);
		}
		return permisoMapper.toDto(permiso);
	}
}