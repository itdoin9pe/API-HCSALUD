package com.saludsystem.submodules.configuracion.service.rol;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Rol;
import com.saludsystem.submodules.configuracion.model.constant.RolConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.RolDao;
import com.saludsystem.submodules.configuracion.port.in.repository.RolRepository;

public class RolEditService
{
	private final RolDao rolDao;
	private final RolRepository rolRepository;

	public RolEditService(RolDao rolDao, RolRepository rolRepository)
	{
		this.rolDao = rolDao;
		this.rolRepository = rolRepository;
	}

	public Rol execute(UUID uuid, Rol rol)
	{
		var currentRol = rolDao.getById(uuid);
		if (currentRol == null)
		{
			throw new IllegalArgumentException(RolConstant.ID_NOT_FOUND);
		}
		if (currentRol.getEstado() != null && currentRol.getEstado() == 0)
		{
			throw new IllegalStateException("El rol ya se encuentra desactivado");
		}
		currentRol.actualizarNombre(rol.getNombre());
		currentRol.actualizarEstado(rol.getEstado());
		return rolRepository.update(uuid, currentRol);
	}
}
