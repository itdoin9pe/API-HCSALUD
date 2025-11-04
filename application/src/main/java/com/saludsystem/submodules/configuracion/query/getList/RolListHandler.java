package com.saludsystem.submodules.configuracion.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.RolMapper;
import com.saludsystem.submodules.configuracion.model.Rol;
import com.saludsystem.submodules.configuracion.model.dtos.RolDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.RolDao;

@Component
public class RolListHandler
{
	private final RolDao rolDao;
	private final RolMapper rolMapper;

	public RolListHandler(RolDao rolDao, RolMapper rolMapper)
	{
		this.rolDao = rolDao;
		this.rolMapper = rolMapper;
	}

	public List<RolDTO> execute()
	{
		List<Rol> rolList = rolDao.getList();
		return rolList.stream().map(rolMapper::toDto).toList();
	}
}