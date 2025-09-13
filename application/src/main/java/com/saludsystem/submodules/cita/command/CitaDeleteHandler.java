package com.saludsystem.submodules.cita.command;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.cita.service.CitaDeleteService;

@Component
public class CitaDeleteHandler
{
	private final CitaDeleteService citaDeleteService;

	public CitaDeleteHandler(CitaDeleteService citaDeleteService)
	{
		this.citaDeleteService = citaDeleteService;
	}

	public void execute(UUID uuid)
	{
		citaDeleteService.execute(uuid);
	}
}