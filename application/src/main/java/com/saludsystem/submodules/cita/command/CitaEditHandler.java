package com.saludsystem.submodules.cita.command;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.model.dtos.command.CitaEditCommand;
import com.saludsystem.submodules.cita.service.CitaEditService;

@Component
public class CitaEditHandler
{
	private final CitaEditService citaEditService;
	private final CitaMapper citaMapper;

	public CitaEditHandler(CitaEditService citaEditService, CitaMapper citaMapper)
	{
		this.citaEditService = citaEditService;
		this.citaMapper = citaMapper;
	}

	public void execute(UUID uuid, CitaEditCommand editCommand)
	{
		var cita = citaMapper.fromUpdateDto(uuid, editCommand);
		citaEditService.execute(uuid, cita);
	}
}