package com.saludsystem.submodules.operaciones.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.service.marca.MarcaDeleteService;

@Component
public class MarcaDeleteHandler
{
	private final MarcaDeleteService marcaDeleteService;

	public MarcaDeleteHandler(MarcaDeleteService marcaDeleteService)
	{
		this.marcaDeleteService = marcaDeleteService;
	}

	public void execute(UUID uuid)
	{
		marcaDeleteService.execute(uuid);
	}
}