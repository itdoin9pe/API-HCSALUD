package com.saludsystem.submodules.paciente.command.delete.evolucion;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.evolucion.altamedica.AltaMedicaDeleteService;

@Component
public class AltaMedicaDeleteHandler
{
	private final AltaMedicaDeleteService altaMedicaDeleteService;

	public AltaMedicaDeleteHandler(AltaMedicaDeleteService altaMedicaDeleteService)
	{
		this.altaMedicaDeleteService = altaMedicaDeleteService;
	}

	public void execute(Long id)
	{
		altaMedicaDeleteService.execute(id);
	}
}