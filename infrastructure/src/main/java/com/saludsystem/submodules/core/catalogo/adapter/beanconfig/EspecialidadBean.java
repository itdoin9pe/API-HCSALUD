package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadCreateService;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadDeleteService;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadEditService;

@Configuration
public class EspecialidadBean
{
	@Bean
	public EspecialidadMapper especialidadMapper()
	{
		return new EspecialidadMapper();
	}

	@Bean
	public EspecialidadCreateService especialidadCreateService(EspecialidadRepository repository)
	{
		return new EspecialidadCreateService(repository);
	}

	@Bean
	public EspecialidadEditService especialidadEditService(EspecialidadDao dao, EspecialidadRepository repository)
	{
		return new EspecialidadEditService(dao, repository);
	}

	@Bean
	public EspecialidadDeleteService especialidadDeleteService(EspecialidadRepository repository, EspecialidadDao dao)
	{
		return new EspecialidadDeleteService(repository, dao);
	}
}
