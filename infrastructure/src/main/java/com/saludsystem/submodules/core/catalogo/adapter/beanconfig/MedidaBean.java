package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;
import com.saludsystem.submodules.catalogo.service.medida.MedidaCreateService;
import com.saludsystem.submodules.catalogo.service.medida.MedidaDeleteService;
import com.saludsystem.submodules.catalogo.service.medida.MedidaEditService;

@Configuration
public class MedidaBean
{
	@Bean
	public MedidaMapper medidaMapper()
	{
		return new MedidaMapper();
	}

	@Bean
	public MedidaCreateService medidaCreateService(MedidaRepository repository)
	{
		return new MedidaCreateService(repository);
	}

	@Bean
	public MedidaEditService medidaEditService(MedidaDao dao, MedidaRepository repository)
	{
		return new MedidaEditService(dao, repository);
	}

	@Bean
	public MedidaDeleteService medidaDeleteService(MedidaRepository repository, MedidaDao dao)
	{
		return new MedidaDeleteService(repository, dao);
	}
}
