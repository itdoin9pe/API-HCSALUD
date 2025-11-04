package com.saludsystem.submodules.core.paciente.adapter.beanconfig.interconsulta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InterconsultaMapper;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InterconsultaDao;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InterconsultaRepository;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.InterconsultaCreateService;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.InterconsultaDeleteService;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.InterconsultaEditService;

@Configuration
public class InterconsultaBean
{
	@Bean
	public InterconsultaMapper interconsultaMapper()
	{
		return new InterconsultaMapper();
	}

	@Bean
	public InterconsultaCreateService interconsultaCreateService(InterconsultaRepository repository)
	{
		return new InterconsultaCreateService(repository);
	}

	@Bean
	public InterconsultaEditService interconsultaEditService(InterconsultaDao dao, InterconsultaRepository repository)
	{
		return new InterconsultaEditService(dao, repository);
	}

	@Bean
	public InterconsultaDeleteService interconsultaDeleteService(
		InterconsultaRepository repository,
		InterconsultaDao dao)
	{
		return new InterconsultaDeleteService(repository, dao);
	}
}
