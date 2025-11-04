package com.saludsystem.submodules.paciente.command.delete.tratamiento;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento.ProcedimientoDeleteService;

@Component
public class ProcedimientoDeleteHandler
{
	private final ProcedimientoDeleteService procedimientoDeleteService;

	public ProcedimientoDeleteHandler(ProcedimientoDeleteService procedimientoDeleteService)
	{
		this.procedimientoDeleteService = procedimientoDeleteService;
	}

	public void execute(UUID uuid)
	{
		procedimientoDeleteService.execute(uuid);
	}
}