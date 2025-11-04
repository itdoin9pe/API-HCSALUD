package com.saludsystem.submodules.paciente.command.create.tratamiento;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.tratamiento.CostoTratamientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento.CostoTratamientoCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.costotratamiento.CostoTratamientoCreateService;

@Component
public class CostoTratamientoCreateHandler
{
	private final CostoTratamientoCreateService costoTratamientoCreateService;
	private final CostoTratamientoMapper costoTratamientoMapper;

	public CostoTratamientoCreateHandler(
		CostoTratamientoCreateService costoTratamientoCreateService,
		CostoTratamientoMapper costoTratamientoMapper)
	{
		this.costoTratamientoCreateService = costoTratamientoCreateService;
		this.costoTratamientoMapper = costoTratamientoMapper;
	}

	public void execute(CostoTratamientoCreateCommand createCommand)
	{
		var costoTratSaved = costoTratamientoMapper.fromCreateDto(createCommand);
		costoTratamientoCreateService.execute(costoTratSaved);
	}
}