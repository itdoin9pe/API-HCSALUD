package com.saludsystem.submodules.mantenimiento.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.model.constant.MonedaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;

@Component
public class MonedaByIdHandler
{
	private final MonedaDao monedaDao;
	private final MonedaMapper monedaMapper;

	public MonedaByIdHandler(MonedaDao monedaDao, MonedaMapper monedaMapper)
	{
		this.monedaDao = monedaDao;
		this.monedaMapper = monedaMapper;
	}

	public MonedaDTO execute(UUID uuid)
	{
		var moneda = monedaDao.getById(uuid);
		if (moneda == null)
		{
			throw new IllegalArgumentException(MonedaConstant.INVALID_ID);
		}
		return monedaMapper.toDto(moneda);
	}
}