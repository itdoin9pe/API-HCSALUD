package com.saludsystem.submodules.paciente.command.delete.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica.ExploracionFisicaDeleteService;

@Component
public class ExploracionFisicaDeleteHandler
{
	private final ExploracionFisicaDeleteService exploracionFisicaDeleteService;

	public ExploracionFisicaDeleteHandler(ExploracionFisicaDeleteService exploracionFisicaDeleteService)
	{
		this.exploracionFisicaDeleteService = exploracionFisicaDeleteService;
	}

	public void execute(UUID uuid)
	{
		exploracionFisicaDeleteService.excute(uuid);
	}
}