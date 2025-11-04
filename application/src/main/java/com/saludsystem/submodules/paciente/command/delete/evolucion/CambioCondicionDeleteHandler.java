package com.saludsystem.submodules.paciente.command.delete.evolucion;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion.CambioCondicionDeleteService;

@Component
public class CambioCondicionDeleteHandler
{
	private final CambioCondicionDeleteService cambioCondicionDeleteService;

	public CambioCondicionDeleteHandler(CambioCondicionDeleteService cambioCondicionDeleteService)
	{
		this.cambioCondicionDeleteService = cambioCondicionDeleteService;
	}

	public void execute(Long id)
	{
		cambioCondicionDeleteService.execute(id);
	}
}