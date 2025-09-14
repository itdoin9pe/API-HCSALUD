package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.CuentaRepository;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaCreateService;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaDeleteService;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaEditService;

@Configuration
public class CuentaBean
{
	@Bean
	public CuentaMapper cuentaMapper()
	{
		return new CuentaMapper();
	}

	@Bean
	public CuentaCreateService cuentaCreateService(CuentaRepository repository)
	{
		return new CuentaCreateService(repository);
	}

	@Bean
	public CuentaEditService cuentaEditService(CuentaDao dao, CuentaRepository repository)
	{
		return new CuentaEditService(dao, repository);
	}

	@Bean
	public CuentaDeleteService cuentaDeleteService(CuentaRepository repository, CuentaDao dao)
	{
		return new CuentaDeleteService(repository, dao);
	}
}
