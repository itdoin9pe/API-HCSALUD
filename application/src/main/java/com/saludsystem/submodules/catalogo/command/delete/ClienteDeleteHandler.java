package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.cliente.ClienteDeleteService;

@Component
public class ClienteDeleteHandler
{
	private final ClienteDeleteService clienteDeleteService;

	public ClienteDeleteHandler(ClienteDeleteService clienteDeleteService)
	{
		this.clienteDeleteService = clienteDeleteService;
	}

	public void execute(UUID uuid)
	{
		clienteDeleteService.execute(uuid);
	}
}