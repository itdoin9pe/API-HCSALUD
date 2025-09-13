package com.saludsystem.submodules.configuracion.service.permiso;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.port.in.dao.PermisoDao;
import com.saludsystem.submodules.configuracion.port.in.repository.PermisoRepository;

@Component
public class PermisoDeleteService
{
	private final PermisoRepository permisoRepository;
	private final PermisoDao permisoDao;

	public PermisoDeleteService(PermisoRepository permisoRepository, PermisoDao permisoDao)
	{
		this.permisoRepository = permisoRepository;
		this.permisoDao = permisoDao;
	}

	public void execute(UUID uuid)
	{
		var permiso = permisoDao.getById(uuid);
		if (permiso.getId() == null)
		{
			throw new IllegalArgumentException("No se puede eliminar un permiso con Id null");
		}
		permisoRepository.delete(uuid);
	}
}
