package com.saludsystem.submodules.mantenimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoDeleteService;

@Component
public class TipoGastoDeleteHandler
{
	private final TipoGastoDeleteService tipoGastoDeleteService;

	public TipoGastoDeleteHandler(TipoGastoDeleteService tipoGastoDeleteService)
	{
		this.tipoGastoDeleteService = tipoGastoDeleteService;
	}

	public void execute(UUID uuid)
	{
		tipoGastoDeleteService.execute(uuid);
	}
}