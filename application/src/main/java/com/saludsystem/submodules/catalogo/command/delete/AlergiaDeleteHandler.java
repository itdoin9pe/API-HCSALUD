package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.alergia.AlergiaDeleteService;

@Component
public class AlergiaDeleteHandler
{
	private final AlergiaDeleteService alergiaDeleteService;

	public AlergiaDeleteHandler(AlergiaDeleteService alergiaDeleteService)
	{
		this.alergiaDeleteService = alergiaDeleteService;
	}

	public void execute(UUID uuid)
	{
		alergiaDeleteService.execute(uuid);
	}
}