package com.saludsystem.submodules.mantenimiento.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.EnfermedadCreateCommand;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadCreateService;

@Component
public class EnfermedadCreateHandler
{
	private final EnfermedadCreateService enfermedadCreateService;
	private final EnfermedadMapper enfermedadMapper;

	public EnfermedadCreateHandler(EnfermedadCreateService enfermedadCreateService, EnfermedadMapper enfermedadMapper)
	{
		this.enfermedadCreateService = enfermedadCreateService;
		this.enfermedadMapper = enfermedadMapper;
	}

	public void execute(EnfermedadCreateCommand createCommand)
	{
		var enfermedad = enfermedadMapper.fromCreateDto(createCommand);
		enfermedadCreateService.execute(enfermedad);
	}
}