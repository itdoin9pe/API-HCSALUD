package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoDeleteService;

@Component
public class ConsentimientoDeleteHandler
{
	private final ConsentimientoDeleteService consentimientoDeleteService;

	public ConsentimientoDeleteHandler(ConsentimientoDeleteService consentimientoDeleteService)
	{
		this.consentimientoDeleteService = consentimientoDeleteService;
	}

	public void execute(UUID uuid)
	{
		consentimientoDeleteService.execute(uuid);
	}
}