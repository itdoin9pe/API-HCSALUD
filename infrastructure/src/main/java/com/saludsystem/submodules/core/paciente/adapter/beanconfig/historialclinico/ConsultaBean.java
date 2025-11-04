package com.saludsystem.submodules.core.paciente.adapter.beanconfig.historialclinico;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ConsultaMapper;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ConsultaDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ConsultaRepository;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.consulta.ConsultaCreateService;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.consulta.ConsultaDeleteService;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.consulta.ConsultaEditService;

@Configuration
public class ConsultaBean
{
	@Bean
	public ConsultaMapper consultaMapper()
	{
		return new ConsultaMapper();
	}

	@Bean
	public ConsultaCreateService consultaCreateService(ConsultaRepository repository)
	{
		return new ConsultaCreateService(repository);
	}

	@Bean
	public ConsultaEditService consultaEditService(ConsultaDao dao, ConsultaRepository repository)
	{
		return new ConsultaEditService(dao, repository);
	}

	@Bean
	public ConsultaDeleteService consultaDeleteService(ConsultaRepository repository, ConsultaDao dao)
	{
		return new ConsultaDeleteService(repository, dao);
	}
}