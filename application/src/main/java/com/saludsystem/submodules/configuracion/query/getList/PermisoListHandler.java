package com.saludsystem.submodules.configuracion.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.PermisoMapper;
import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.configuracion.model.dtos.PermisoDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.PermisoDao;

@Component
public class PermisoListHandler
{
	private final PermisoDao permisoDao;
	private final PermisoMapper permisoMapper;

	public PermisoListHandler(PermisoDao permisoDao, PermisoMapper permisoMapper)
	{
		this.permisoDao = permisoDao;
		this.permisoMapper = permisoMapper;
	}

	public List<PermisoDTO> execute()
	{
		List<Permiso> permisoList = permisoDao.getList();
		return permisoList.stream().map(permisoMapper::toDto).toList();
	}
}