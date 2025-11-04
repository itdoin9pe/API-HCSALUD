package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoDeleteService;

@Component
public class TipoCitadoDeleteHandler
{
	public final TipoCitadoDeleteService tipoCitadoDeleteService;

	public TipoCitadoDeleteHandler(TipoCitadoDeleteService tipoCitadoDeleteService)
	{
		this.tipoCitadoDeleteService = tipoCitadoDeleteService;
	}

	public void execute(UUID uuid)
	{
		tipoCitadoDeleteService.execute(uuid);
	}
}