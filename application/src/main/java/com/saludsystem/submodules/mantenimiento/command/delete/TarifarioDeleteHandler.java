package com.saludsystem.submodules.mantenimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioDeleteService;

@Component
public class TarifarioDeleteHandler
{
	private final TarifarioDeleteService tarifarioDeleteService;

	public TarifarioDeleteHandler(TarifarioDeleteService tarifarioDeleteService)
	{
		this.tarifarioDeleteService = tarifarioDeleteService;
	}

	public void execute(UUID uuid)
	{
		tarifarioDeleteService.execute(uuid);
	}
}