package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoDeleteService;

@Component
public class ApoderadoDeleteHandler
{
	private final ApoderadoDeleteService apoderadoDeleteService;

	public ApoderadoDeleteHandler(ApoderadoDeleteService apoderadoDeleteService)
	{
		this.apoderadoDeleteService = apoderadoDeleteService;
	}

	public void execute(UUID uuid)
	{
		apoderadoDeleteService.execute(uuid);
	}
}