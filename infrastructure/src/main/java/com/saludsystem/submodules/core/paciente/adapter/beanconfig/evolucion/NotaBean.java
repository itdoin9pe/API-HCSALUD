package com.saludsystem.submodules.core.paciente.adapter.beanconfig.evolucion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.evolucion.NotaMapper;
import com.saludsystem.submodules.paciente.port.dao.evolucion.NotaDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.NotaRepository;
import com.saludsystem.submodules.paciente.service.historia.evolucion.nota.NotaCreateService;
import com.saludsystem.submodules.paciente.service.historia.evolucion.nota.NotaDeleteService;
import com.saludsystem.submodules.paciente.service.historia.evolucion.nota.NotaEditService;

@Configuration
public class NotaBean
{
	@Bean
	public NotaMapper notaMapper()
	{
		return new NotaMapper();
	}

	@Bean
	public NotaCreateService notaCreateService(NotaRepository repository)
	{
		return new NotaCreateService(repository);
	}

	@Bean
	public NotaEditService notaEditService(NotaDao dao, NotaRepository repository)
	{
		return new NotaEditService(dao, repository);
	}

	@Bean
	public NotaDeleteService notaDeleteService(NotaRepository repository, NotaDao dao)
	{
		return new NotaDeleteService(repository, dao);
	}
}