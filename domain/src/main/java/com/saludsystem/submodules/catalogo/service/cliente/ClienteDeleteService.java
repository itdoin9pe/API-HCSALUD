package com.saludsystem.submodules.catalogo.service.cliente;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;

public class ClienteDeleteService
{
	private final ClienteRepository clienteRepository;
	private final ClienteDao clienteDao;

	public ClienteDeleteService(ClienteRepository clienteRepository, ClienteDao clienteDao)
	{
		this.clienteRepository = clienteRepository;
		this.clienteDao = clienteDao;
	}

	public void execute(UUID uuid)
	{
		var cliente = clienteDao.getById(uuid);
		if (cliente.getEstado() != null && cliente.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliiminar el cliente, ya se encuentra desactivado");
		}
		clienteRepository.delete(uuid);
	}
}