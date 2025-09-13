package com.saludsystem.submodules.configuracion.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.service.sede.SedeDeleteService;

@Component
public class SedeDeleteHandler
{
	private final SedeDeleteService sedeDeleteService;

	public SedeDeleteHandler(SedeDeleteService sedeDeleteService)
	{
		this.sedeDeleteService = sedeDeleteService;
	}

	public void execute(UUID uuid)
	{
		sedeDeleteService.execute(uuid);
	}
}