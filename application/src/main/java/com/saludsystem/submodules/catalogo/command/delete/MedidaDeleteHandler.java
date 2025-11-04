package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.medida.MedidaDeleteService;

@Component
public class MedidaDeleteHandler
{
	private final MedidaDeleteService medidaDeleteService;

	public MedidaDeleteHandler(MedidaDeleteService medidaDeleteService)
	{
		this.medidaDeleteService = medidaDeleteService;
	}

	public void execute(UUID uuid)
	{
		medidaDeleteService.execute(uuid);
	}
}