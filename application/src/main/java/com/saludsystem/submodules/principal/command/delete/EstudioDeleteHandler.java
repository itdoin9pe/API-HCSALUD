package com.saludsystem.submodules.principal.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.service.estudio.EstudioDeleteService;

@Component
public class EstudioDeleteHandler
{
	private final EstudioDeleteService estudioDeleteService;

	public EstudioDeleteHandler(EstudioDeleteService estudioDeleteService)
	{
		this.estudioDeleteService = estudioDeleteService;
	}

	public void execute(UUID uuid)
	{
		estudioDeleteService.execute(uuid);
	}
}