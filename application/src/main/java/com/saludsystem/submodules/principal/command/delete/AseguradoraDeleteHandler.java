package com.saludsystem.submodules.principal.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraDeleteService;

@Component
public class AseguradoraDeleteHandler
{
	private final AseguradoraDeleteService aseguradoraDeleteService;

	public AseguradoraDeleteHandler(AseguradoraDeleteService aseguradoraDeleteService)
	{
		this.aseguradoraDeleteService = aseguradoraDeleteService;
	}

	public void execute(UUID uuid)
	{
		aseguradoraDeleteService.execute(uuid);
	}
}