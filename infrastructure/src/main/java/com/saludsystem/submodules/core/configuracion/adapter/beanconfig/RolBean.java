package com.saludsystem.submodules.core.configuracion.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.configuracion.mapper.RolMapper;
import com.saludsystem.submodules.configuracion.port.in.dao.RolDao;
import com.saludsystem.submodules.configuracion.port.in.repository.RolRepository;
import com.saludsystem.submodules.configuracion.service.rol.RolCreateService;
import com.saludsystem.submodules.configuracion.service.rol.RolDeleteService;
import com.saludsystem.submodules.configuracion.service.rol.RolEditService;

@Configuration
public class RolBean
{
	@Bean
	public RolMapper rolMapper()
	{
		return new RolMapper();
	}

	@Bean
	public RolCreateService rolCreateService(RolRepository repository)
	{
		return new RolCreateService(repository);
	}

	@Bean
	public RolEditService rolEditService(RolDao dao, RolRepository repository)
	{
		return new RolEditService(dao, repository);
	}

	@Bean
	public RolDeleteService rolDeleteService(RolRepository repository, RolDao dao)
	{
		return new RolDeleteService(repository, dao);
	}
}
