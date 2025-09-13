package com.saludsystem.submodules.configuracion.service.permiso;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.model.Permiso;
import com.saludsystem.submodules.configuracion.model.constant.PermisoConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.PermisoDao;
import com.saludsystem.submodules.configuracion.port.in.repository.PermisoRepository;

@Component
public class PermisoEditService
{
	private final PermisoDao permisoDao;
	private final PermisoRepository permisoRepository;

	public PermisoEditService(PermisoDao permisoDao, PermisoRepository permisoRepository)
	{
		this.permisoDao = permisoDao;
		this.permisoRepository = permisoRepository;
	}

	public Permiso execute(UUID uuid, Permiso permiso)
	{
		var currentPermiso = permisoDao.getById(uuid);
		if (currentPermiso == null)
		{
			throw new IllegalArgumentException(PermisoConstant.INVALID_ID);
		}
		currentPermiso.actualizarDelete(permiso.getDelete());
		currentPermiso.actualizarInsert(permiso.getInsert());
		currentPermiso.actualizarRead(permiso.getRead());
		currentPermiso.actualizarUpdate(permiso.getUpdate());
		currentPermiso.actualizarRolId(permiso.getRolId());
		currentPermiso.actualizarMenuId(permiso.getMenuId());
		return permisoRepository.update(uuid, permiso);
	}
}
