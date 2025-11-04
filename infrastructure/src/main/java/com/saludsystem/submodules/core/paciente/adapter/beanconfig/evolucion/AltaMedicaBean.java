package com.saludsystem.submodules.core.paciente.adapter.beanconfig.evolucion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.evolucion.AltaMedicaMapper;
import com.saludsystem.submodules.paciente.port.dao.evolucion.AltaMedicaDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.AltaMedicaRepository;
import com.saludsystem.submodules.paciente.service.historia.evolucion.altamedica.AltaMedicaCreateService;
import com.saludsystem.submodules.paciente.service.historia.evolucion.altamedica.AltaMedicaDeleteService;
import com.saludsystem.submodules.paciente.service.historia.evolucion.altamedica.AltaMedicaEditService;

@Configuration
public class AltaMedicaBean
{
	@Bean
	public AltaMedicaMapper altaMedicaMapper()
	{
		return new AltaMedicaMapper();
	}
 
	@Bean
	public AltaMedicaCreateService altaMedicaCreateService(AltaMedicaRepository repository)
	{
		return new AltaMedicaCreateService(repository);
	}

	@Bean
	public AltaMedicaEditService altaMedicaEditService(AltaMedicaDao dao, AltaMedicaRepository repository)
	{
		return new AltaMedicaEditService(dao, repository);
	}

	@Bean
	public AltaMedicaDeleteService altaMedicaDeleteService(AltaMedicaRepository repository, AltaMedicaDao dao)
	{
		return new AltaMedicaDeleteService(repository, dao);
	}
}