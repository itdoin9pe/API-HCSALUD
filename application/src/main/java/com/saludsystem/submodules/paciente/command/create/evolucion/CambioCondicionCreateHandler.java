package com.saludsystem.submodules.paciente.command.create.evolucion;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.evolucion.CambioCondicionMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.CambioCondicionCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion.CambioCondicionCreateService;

@Component
public class CambioCondicionCreateHandler
{
	private final CambioCondicionCreateService cambioCondicionCreateService;
	private final CambioCondicionMapper cambioCondicionMapper;

	public CambioCondicionCreateHandler(
		CambioCondicionCreateService cambioCondicionCreateService,
		CambioCondicionMapper cambioCondicionMapper)
	{
		this.cambioCondicionCreateService = cambioCondicionCreateService;
		this.cambioCondicionMapper = cambioCondicionMapper;
	}

	public void execute(CambioCondicionCreateCommand createCommand)
	{
		var cambioCondicSaced = cambioCondicionMapper.fromCreateDto(createCommand);
		cambioCondicionCreateService.execute(cambioCondicSaced);
	}
}