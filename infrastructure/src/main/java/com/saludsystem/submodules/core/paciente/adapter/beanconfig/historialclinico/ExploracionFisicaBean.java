package com.saludsystem.submodules.core.paciente.adapter.beanconfig.historialclinico;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ExploracionFisicaMapper;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ExploracionFisicaDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ExploracionFisicaRepository;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica.ExploracionFisicaCreateService;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica.ExploracionFisicaDeleteService;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica.ExploracionFisicaEditService;

@Configuration
public class ExploracionFisicaBean
{
	@Bean
	public ExploracionFisicaMapper exploracionFisicaMapper()
	{
		return new ExploracionFisicaMapper();
	}

	@Bean
	public ExploracionFisicaCreateService exploracionFisicaCreateService(ExploracionFisicaRepository repository)
	{
		return new ExploracionFisicaCreateService(repository);
	}

	@Bean
	public ExploracionFisicaEditService exploracionFisicaEditService(
		ExploracionFisicaDao dao,
		ExploracionFisicaRepository repository)
	{
		return new ExploracionFisicaEditService(dao, repository);
	}

	@Bean
	public ExploracionFisicaDeleteService exploracionFisicaDeleteService(
		ExploracionFisicaRepository repository,
		ExploracionFisicaDao dao)
	{
		return new ExploracionFisicaDeleteService(repository, dao);
	}
}