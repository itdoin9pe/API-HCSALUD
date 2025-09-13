package com.saludsystem.submodules.principal.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.SucursalMapper;
import com.saludsystem.submodules.principal.model.Sucursal;
import com.saludsystem.submodules.principal.model.dtos.SucursalDTO;
import com.saludsystem.submodules.principal.port.dao.SucursalDao;

@Component
public class SucursalListHandler
{
	private final SucursalDao sucursalDao;
	private final SucursalMapper sucursalMapper;

	public SucursalListHandler(SucursalDao sucursalDao, SucursalMapper sucursalMapper)
	{
		this.sucursalDao = sucursalDao;
		this.sucursalMapper = sucursalMapper;
	}

	public List<SucursalDTO> execute()
	{
		List<Sucursal> sucursalList = sucursalDao.getList();
		return sucursalList.stream().map(sucursalMapper::toDto).toList();
	}
}