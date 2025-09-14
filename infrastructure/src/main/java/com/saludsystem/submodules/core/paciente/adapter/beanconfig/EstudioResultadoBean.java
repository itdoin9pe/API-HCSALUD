package com.saludsystem.submodules.core.paciente.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.EstudioResultadoMapper;
import com.saludsystem.submodules.paciente.port.dao.EstudioResultadoDao;
import com.saludsystem.submodules.paciente.port.repository.EstudioResultadoRepository;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudioresultado.EstudioResultadoCreateService;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudioresultado.EstudioResultadoDeleteService;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudioresultado.EstudioResultadoEditService;

@Configuration
public class EstudioResultadoBean
{
	@Bean
	public EstudioResultadoMapper estudioResultadoMapper()
	{
		return new EstudioResultadoMapper();
	}

	@Bean
	public EstudioResultadoCreateService estudioResultadoCreateService(EstudioResultadoRepository repository)
	{
		return new EstudioResultadoCreateService(repository);
	}

	@Bean
	public EstudioResultadoEditService estudioResultadoEditService(
		EstudioResultadoDao dao,
		EstudioResultadoRepository repository)
	{
		return new EstudioResultadoEditService(dao, repository);
	}

	@Bean
	public EstudioResultadoDeleteService estudioResultadoDeleteService(
		EstudioResultadoRepository repository,
		EstudioResultadoDao dao)
	{
		return new EstudioResultadoDeleteService(repository, dao);
	}
}