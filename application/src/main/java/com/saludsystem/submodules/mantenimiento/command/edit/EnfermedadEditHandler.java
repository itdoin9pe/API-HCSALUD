package com.saludsystem.submodules.mantenimiento.command.edit;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.EnfermedadEditCommand;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadEditService;

@Component
public class EnfermedadEditHandler
{
	private final EnfermedadEditService enfermedadEditService;
	private final EnfermedadMapper enfermedadMapper;

	public EnfermedadEditHandler(EnfermedadEditService enfermedadEditService, EnfermedadMapper enfermedadMapper)
	{
		this.enfermedadEditService = enfermedadEditService;
		this.enfermedadMapper = enfermedadMapper;
	}

	public void execute(String id, EnfermedadEditCommand editCommand)
	{
		var enfermedad = enfermedadMapper.fromUpdateDto(id, editCommand);
		enfermedadEditService.execute(id, enfermedad);
	}
}