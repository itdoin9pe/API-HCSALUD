package com.saludsystem.submodules.paciente.command.edit.tratamiento;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.tratamiento.ProcedimientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento.ProcedimientoEditCommand;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento.ProcedimientoEditService;

@Component
public class ProcedimientoEditHandler
{
	private final ProcedimientoEditService procedimientoEditService;
	private final ProcedimientoMapper procedimientoMapper;

	public ProcedimientoEditHandler(
		ProcedimientoEditService procedimientoEditService,
		ProcedimientoMapper procedimientoMapper)
	{
		this.procedimientoEditService = procedimientoEditService;
		this.procedimientoMapper = procedimientoMapper;
	}

	public void execute(UUID uuid, ProcedimientoEditCommand editCommand)
	{
		var procedimientoUpdated = procedimientoMapper.fromUpdateDto(uuid, editCommand);
		procedimientoEditService.execute(uuid, procedimientoUpdated);
	}
}