package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadDeleteService;

@Component
public class EspecialidadDeleteHandler
{
	private final EspecialidadDeleteService especialidadDeleteService;

	public EspecialidadDeleteHandler(EspecialidadDeleteService especialidadDeleteService)
	{
		this.especialidadDeleteService = especialidadDeleteService;
	}

	public void execute(UUID uuid)
	{
		especialidadDeleteService.execute(uuid);
	}
}