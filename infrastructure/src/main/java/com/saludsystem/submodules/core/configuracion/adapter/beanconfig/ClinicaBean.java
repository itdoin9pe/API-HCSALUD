package com.saludsystem.submodules.core.configuracion.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.configuracion.mapper.ClinicaMapper;
import com.saludsystem.submodules.configuracion.port.in.dao.SysSaludDao;
import com.saludsystem.submodules.configuracion.port.in.repository.SysSaludRepository;
import com.saludsystem.submodules.configuracion.service.clinica.ClinicaCreateService;
import com.saludsystem.submodules.configuracion.service.clinica.ClinicaDeleteService;
import com.saludsystem.submodules.configuracion.service.clinica.ClinicaEditService;

@Configuration
public class ClinicaBean
{
	@Bean
	public ClinicaMapper clinicaMapper()
	{
		return new ClinicaMapper();
	}

	@Bean
	public ClinicaCreateService clinicaCreateService(SysSaludRepository repository)
	{
		return new ClinicaCreateService(repository);
	}

	@Bean
	public ClinicaEditService clinicaEditService(SysSaludDao dao, SysSaludRepository repository)
	{
		return new ClinicaEditService(dao, repository);
	}

	@Bean
	public ClinicaDeleteService clinicaDeleteService(SysSaludRepository repository, SysSaludDao dao)
	{
		return new ClinicaDeleteService(repository, dao);
	}
}
