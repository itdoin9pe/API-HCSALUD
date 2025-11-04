package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.port.dao.EstudioDao;
import com.saludsystem.submodules.principal.port.repository.EstudioRepository;
import com.saludsystem.submodules.principal.service.estudio.EstudioCreateService;
import com.saludsystem.submodules.principal.service.estudio.EstudioDeleteService;
import com.saludsystem.submodules.principal.service.estudio.EstudioEditService;

@Configuration
public class EstudioBean
{
	@Bean
	public EstudioMapper estudioMapper()
	{
		return new EstudioMapper();
	}

	@Bean
	public EstudioCreateService estudioCreateService(EstudioRepository repository)
	{
		return new EstudioCreateService(repository);
	}

	@Bean
	public EstudioEditService estudioEditService(EstudioDao dao, EstudioRepository repository)
	{
		return new EstudioEditService(dao, repository);
	}

	@Bean
	public EstudioDeleteService estudioDeleteService(EstudioRepository repository, EstudioDao dao)
	{
		return new EstudioDeleteService(repository, dao);
	}
}
