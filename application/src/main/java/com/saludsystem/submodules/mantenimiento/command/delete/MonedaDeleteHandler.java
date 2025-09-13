package com.saludsystem.submodules.mantenimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaDeleteService;

@Component
public class MonedaDeleteHandler
{
	private final MonedaDeleteService monedaDeleteService;

	public MonedaDeleteHandler(MonedaDeleteService monedaDeleteService)
	{
		this.monedaDeleteService = monedaDeleteService;
	}

	public void execute(UUID uuid)
	{
		monedaDeleteService.execute(uuid);
	}
}