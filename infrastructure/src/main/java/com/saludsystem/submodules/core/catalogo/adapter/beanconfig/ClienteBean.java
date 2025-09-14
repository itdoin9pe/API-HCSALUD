package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteCreateService;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteDeleteService;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteEditService;

@Configuration
public class ClienteBean
{
	@Bean
	public ClienteMapper clienteMapper()
	{
		return new ClienteMapper();
	}

	@Bean
	public ClienteCreateService clienteCreateService(ClienteRepository repository)
	{
		return new ClienteCreateService(repository);
	}

	@Bean
	public ClienteEditService clienteEditService(ClienteDao dao, ClienteRepository repository)
	{
		return new ClienteEditService(dao, repository);
	}

	@Bean
	public ClienteDeleteService clienteDeleteService(ClienteRepository repository, ClienteDao dao)
	{
		return new ClienteDeleteService(repository, dao);
	}
}
