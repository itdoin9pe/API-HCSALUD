package com.saludsystem.submodules.paciente.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.fichaclinica.receta.RecetaDeleteService;

@Component
public class RecetaDeleteHandler
{
	private final RecetaDeleteService recetaDeleteService;

	public RecetaDeleteHandler(RecetaDeleteService recetaDeleteService)
	{
		this.recetaDeleteService = recetaDeleteService;
	}

	public void execute(UUID uuid)
	{
		recetaDeleteService.execute(uuid);
	}
}