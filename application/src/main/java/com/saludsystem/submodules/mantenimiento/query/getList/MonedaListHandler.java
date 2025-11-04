package com.saludsystem.submodules.mantenimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.model.dtos.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;

@Component
public class MonedaListHandler
{
	private final MonedaDao monedaDao;
	private final MonedaMapper monedaMapper;

	public MonedaListHandler(MonedaDao monedaDao, MonedaMapper monedaMapper)
	{
		this.monedaDao = monedaDao;
		this.monedaMapper = monedaMapper;
	}

	public List<MonedaDTO> execute()
	{
		List<Moneda> monedaList = monedaDao.getList();
		return monedaList.stream().map(monedaMapper::toDto).toList();
	}
}