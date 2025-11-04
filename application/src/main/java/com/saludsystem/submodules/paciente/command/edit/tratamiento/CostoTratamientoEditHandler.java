package com.saludsystem.submodules.paciente.command.edit.tratamiento;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.tratamiento.CostoTratamientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento.CostoTratamientoEditCommand;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.costotratamiento.CostoTratamientoEditService;

@Component
public class CostoTratamientoEditHandler
{
	private final CostoTratamientoEditService costoTratamientoEditService;
	private final CostoTratamientoMapper costoTratamientoMapper;

	public CostoTratamientoEditHandler(
		CostoTratamientoEditService costoTratamientoEditService,
		CostoTratamientoMapper costoTratamientoMapper)
	{
		this.costoTratamientoEditService = costoTratamientoEditService;
		this.costoTratamientoMapper = costoTratamientoMapper;
	}

	public void execute(UUID uuid, CostoTratamientoEditCommand editCommand)
	{
		var costoTratamientoUpdated = costoTratamientoMapper.fromUpdateDto(uuid, editCommand);
		costoTratamientoEditService.execute(uuid, costoTratamientoUpdated);
	}
}