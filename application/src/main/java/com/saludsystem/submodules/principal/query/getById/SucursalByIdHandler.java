package com.saludsystem.submodules.principal.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.SucursalMapper;
import com.saludsystem.submodules.principal.model.constant.SucursalConstant;
import com.saludsystem.submodules.principal.model.dtos.SucursalDTO;
import com.saludsystem.submodules.principal.port.dao.SucursalDao;

@Component
public class SucursalByIdHandler
{
	private final SucursalDao sucursalDao;
	private final SucursalMapper sucursalMapper;

	public SucursalByIdHandler(SucursalDao sucursalDao, SucursalMapper sucursalMapper)
	{
		this.sucursalDao = sucursalDao;
		this.sucursalMapper = sucursalMapper;
	}

	public SucursalDTO execute(UUID uuid)
	{
		var sucursal = sucursalDao.getById(uuid);
		if (sucursal == null)
		{
			throw new IllegalArgumentException(SucursalConstant.INVALID_ID);
		}
		return sucursalMapper.toDto(sucursal);
	}
}