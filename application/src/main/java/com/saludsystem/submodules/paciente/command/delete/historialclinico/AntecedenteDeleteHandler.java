package com.saludsystem.submodules.paciente.command.delete.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.historialclinico.antecedente.AntecedenteDeleteService;

@Component
public class AntecedenteDeleteHandler
{
	private final AntecedenteDeleteService antecedenteDeleteService;

	public AntecedenteDeleteHandler(AntecedenteDeleteService antecedenteDeleteService)
	{
		this.antecedenteDeleteService = antecedenteDeleteService;
	}

	public void execute(UUID uuid)
	{
		antecedenteDeleteService.execute(uuid);
	}
}