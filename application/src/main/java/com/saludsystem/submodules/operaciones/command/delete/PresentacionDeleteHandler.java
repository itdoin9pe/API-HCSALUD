package com.saludsystem.submodules.operaciones.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.service.presentacion.PresentacionDeleteService;

@Component
public class PresentacionDeleteHandler
{
	private final PresentacionDeleteService presentacionDeleteService;

	public PresentacionDeleteHandler(PresentacionDeleteService presentacionDeleteService)
	{
		this.presentacionDeleteService = presentacionDeleteService;
	}

	public void execute(UUID uuid)
	{
		presentacionDeleteService.execute(uuid);
	}
}