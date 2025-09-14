package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoCreateService;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoDeleteService;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoEditService;
import com.saludsystem.submodules.core.catalogo.adapter.seeder.ApoderadoSeederService;

@Configuration
public class ApoderadoBean
{
	@Bean
	public ApoderadoMapper apoderadoMapper()
	{
		return new ApoderadoMapper();
	}

	@Bean
	public ApoderadoCreateService apoderadoCreateService(ApoderadoRepository repository)
	{
		return new ApoderadoCreateService(repository);
	}

	@Bean
	public ApoderadoEditService apoderadoEditService(ApoderadoDao dao, ApoderadoRepository repository)
	{
		return new ApoderadoEditService(dao, repository);
	}

	@Bean
	public ApoderadoDeleteService apoderadoDeleteService(ApoderadoRepository repository, ApoderadoDao dao)
	{
		return new ApoderadoDeleteService(repository, dao);
	}

	@Bean
	CommandLineRunner runner(ApoderadoSeederService seeder)
	{
		return args -> seeder.insertarMasivo();
	}
}
