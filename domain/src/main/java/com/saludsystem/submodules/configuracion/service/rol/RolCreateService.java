package com.saludsystem.submodules.configuracion.service.rol;

import com.saludsystem.submodules.configuracion.model.Rol;
import com.saludsystem.submodules.configuracion.port.in.repository.RolRepository;

public class RolCreateService
{
	private final RolRepository rolRepository;

	public RolCreateService(RolRepository rolRepository)
	{
		this.rolRepository = rolRepository;
	}

	public Rol execute(Rol rol)
	{

		return rolRepository.save(rol);

	}
}
