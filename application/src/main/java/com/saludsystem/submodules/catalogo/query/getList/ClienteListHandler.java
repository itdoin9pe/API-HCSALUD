package com.saludsystem.submodules.catalogo.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.model.dto.ClienteDTO;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;

@Component
public class ClienteListHandler
{
	private final ClienteDao clienteDao;
	private final ClienteMapper clienteMapper;

	public ClienteListHandler(ClienteDao clienteDao, ClienteMapper clienteMapper)
	{
		this.clienteDao = clienteDao;
		this.clienteMapper = clienteMapper;
	}

	public List<ClienteDTO> execute()
	{
		List<Cliente> clienteList = clienteDao.getList();
		return clienteList.stream().map(clienteMapper::toDto).toList();
	}
}