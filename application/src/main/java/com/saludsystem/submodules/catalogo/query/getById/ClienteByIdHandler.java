package com.saludsystem.submodules.catalogo.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.constant.ClienteConstant;
import com.saludsystem.submodules.catalogo.model.dto.ClienteDTO;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;

@Component
public class ClienteByIdHandler
{
	private final ClienteDao clienteDao;
	private final ClienteMapper clienteMapper;

	public ClienteByIdHandler(ClienteDao clienteDao, ClienteMapper clienteMapper)
	{
		this.clienteDao = clienteDao;
		this.clienteMapper = clienteMapper;
	}

	public ClienteDTO execute(UUID uuid)
	{
		var cliente = clienteDao.getById(uuid);
		if (cliente == null)
		{
			throw new IllegalArgumentException(ClienteConstant.INVALID_ID);
		}
		return clienteMapper.toDto(cliente);
	}
}