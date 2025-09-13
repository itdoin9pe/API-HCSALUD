package com.saludsystem.submodules.paciente.command.create.evolucion;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.evolucion.AltaMedicaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.AltaMedicaCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.evolucion.altamedica.AltaMedicaCreateService;

@Component
public class AltaMedicaCreateHandler
{
	private final AltaMedicaCreateService altaMedicaCreateService;
	private final AltaMedicaMapper altaMedicaMapper;

	public AltaMedicaCreateHandler(AltaMedicaCreateService altaMedicaCreateService, AltaMedicaMapper altaMedicaMapper)
	{
		this.altaMedicaCreateService = altaMedicaCreateService;
		this.altaMedicaMapper = altaMedicaMapper;
	}

	public void execute(AltaMedicaCreateCommand createCommand)
	{
		var altaMedicaSaved = altaMedicaMapper.fromCreateDto(createCommand);
		altaMedicaCreateService.execute(altaMedicaSaved);
	}
}