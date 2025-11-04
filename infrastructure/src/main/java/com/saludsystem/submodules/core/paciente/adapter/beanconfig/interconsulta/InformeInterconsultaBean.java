package com.saludsystem.submodules.core.paciente.adapter.beanconfig.interconsulta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InformeInterconsultaMapper;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InformeInterconsultaDao;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InformeInterconsultaRepository;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.informeinterconsulta.InformeInterCreateService;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.informeinterconsulta.InformeInterDeleteService;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.informeinterconsulta.InformeInterEditService;

@Configuration
public class InformeInterconsultaBean
{
	@Bean
	public InformeInterconsultaMapper informeInterconsultaMapper()
	{
		return new InformeInterconsultaMapper();
	}

	@Bean
	public InformeInterCreateService informeInterCreateService(InformeInterconsultaRepository repository)
	{
		return new InformeInterCreateService(repository);
	}

	@Bean
	public InformeInterEditService informeInterEditService(
		InformeInterconsultaDao dao,
		InformeInterconsultaRepository repository)
	{
		return new InformeInterEditService(dao, repository);
	}

	@Bean
	public InformeInterDeleteService informeInterDeleteService(
		InformeInterconsultaRepository repository,
		InformeInterconsultaDao dao)
	{
		return new InformeInterDeleteService(repository, dao);
	}
}
