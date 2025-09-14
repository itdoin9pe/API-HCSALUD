package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.port.dao.EmpresaDao;
import com.saludsystem.submodules.principal.port.repository.EmpresaRepository;
import com.saludsystem.submodules.principal.service.empresa.EmpresaCreateService;
import com.saludsystem.submodules.principal.service.empresa.EmpresaDeleteService;
import com.saludsystem.submodules.principal.service.empresa.EmpresaEditService;

@Configuration
public class EmpresaBean
{
	@Bean
	public EmpresaMapper empresaMapper()
	{
		return new EmpresaMapper();
	}

	@Bean
	public EmpresaCreateService empresaCreateService(EmpresaRepository repository)
	{
		return new EmpresaCreateService(repository);
	}

	@Bean
	public EmpresaEditService empresaEditService(EmpresaDao dao, EmpresaRepository repository)
	{
		return new EmpresaEditService(dao, repository);
	}

	@Bean
	public EmpresaDeleteService empresaDeleteService(EmpresaRepository repository, EmpresaDao dao)
	{
		return new EmpresaDeleteService(repository, dao);
	}
}
