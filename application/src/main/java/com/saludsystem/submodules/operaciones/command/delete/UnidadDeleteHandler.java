package com.saludsystem.submodules.operaciones.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.service.unidad.UnidadDeleteService;

@Component
public class UnidadDeleteHandler
{
	private final UnidadDeleteService unidadDeleteService;

	public UnidadDeleteHandler(UnidadDeleteService unidadDeleteService)
	{
		this.unidadDeleteService = unidadDeleteService;
	}

	public void execute(UUID uuid)
	{
		unidadDeleteService.execute(uuid);
	}
}