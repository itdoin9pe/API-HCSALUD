package com.saludsystem.submodules.core.movimiento.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.CompraMapper;
import com.saludsystem.submodules.movimiento.port.dao.CompraDao;
import com.saludsystem.submodules.movimiento.port.repository.CompraRepository;
import com.saludsystem.submodules.movimiento.service.compra.CompraCreateService;
import com.saludsystem.submodules.movimiento.service.compra.CompraDeleteService;
import com.saludsystem.submodules.movimiento.service.compra.CompraEditService;

@Component
public class CompraBean
{
	@Bean
	public CompraMapper compraMapper()
	{
		return new CompraMapper();
	}

	@Bean
	public CompraCreateService compraCreateService(CompraRepository repository)
	{
		return new CompraCreateService(repository);
	}

	@Bean
	public CompraEditService compraEditService(CompraDao dao, CompraRepository repository)
	{
		return new CompraEditService(dao, repository);
	}

	@Bean
	public CompraDeleteService compraDeleteService(CompraRepository repository, CompraDao dao)
	{
		return new CompraDeleteService(repository, dao);
	}
}
