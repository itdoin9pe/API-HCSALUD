package com.saludsystem.submodules.mantenimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoDeleteService;

@Component
public class TipoPagoDeleteHandler
{
	private final TipoPagoDeleteService tipoPagoDeleteService;

	public TipoPagoDeleteHandler(TipoPagoDeleteService tipoPagoDeleteService)
	{
		this.tipoPagoDeleteService = tipoPagoDeleteService;
	}

	public void execute(UUID uuid)
	{
		tipoPagoDeleteService.execute(uuid);
	}
}