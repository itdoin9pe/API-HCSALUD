package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;
import com.saludsystem.submodules.principal.port.repository.AseguradoraRepository;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraCreateService;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraDeleteService;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraEdiService;

@Configuration
public class AseguradoraBean
{
	@Bean
	public AseguradoraMapper aseguradoraMapper()
	{
		return new AseguradoraMapper();
	}

	@Bean
	public AseguradoraCreateService aseguradoraCreateService(AseguradoraRepository repository)
	{
		return new AseguradoraCreateService(repository);
	}

	@Bean
	public AseguradoraEdiService aseguradoraEdiService(AseguradoraDao dao, AseguradoraRepository repository)
	{
		return new AseguradoraEdiService(dao, repository);
	}

	@Bean
	public AseguradoraDeleteService aseguradoraDeleteService(AseguradoraRepository repository, AseguradoraDao dao)
	{
		return new AseguradoraDeleteService(repository, dao);
	}
}
