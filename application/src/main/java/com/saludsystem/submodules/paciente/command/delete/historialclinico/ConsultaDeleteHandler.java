package com.saludsystem.submodules.paciente.command.delete.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.historialclinico.consulta.ConsultaDeleteService;

@Component
public class ConsultaDeleteHandler
{
	private final ConsultaDeleteService consultaDeleteService;

	public ConsultaDeleteHandler(ConsultaDeleteService consultaDeleteService)
	{
		this.consultaDeleteService = consultaDeleteService;
	}

	public void execute(UUID uuid)
	{
		consultaDeleteService.execute(uuid);
	}
}