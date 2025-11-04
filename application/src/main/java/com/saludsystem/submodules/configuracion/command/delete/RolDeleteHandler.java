package com.saludsystem.submodules.configuracion.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.service.rol.RolDeleteService;

@Component
public class RolDeleteHandler
{
	private final RolDeleteService rolDeleteService;

	public RolDeleteHandler(RolDeleteService rolDeleteService)
	{
		this.rolDeleteService = rolDeleteService;
	}

	public void execute(UUID uuid)
	{
		rolDeleteService.execute(uuid);
	}
}