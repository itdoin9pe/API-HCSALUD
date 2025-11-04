package com.saludsystem.submodules.core.cita.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;
import com.saludsystem.submodules.cita.service.CitaCreateService;
import com.saludsystem.submodules.cita.service.CitaDeleteService;
import com.saludsystem.submodules.cita.service.CitaEditService;
import com.saludsystem.submodules.cita.service.DisponibilidadService;

@Configuration
public class CitaBean
{
	@Bean
	public CitaMapper citaMapper()
	{
		return new CitaMapper();
	}
	
	@Bean
	public DisponibilidadService disponibilidadService() {
	    return new DisponibilidadService();
	}

	@Bean
	public CitaCreateService citaCreateService(CitaDao dao, CitaRepository repository, DisponibilidadService service)
	{
		return new CitaCreateService(dao, repository, service);
	}

	@Bean
	public CitaEditService citaEditService(CitaDao dao, CitaRepository repository)
	{
		return new CitaEditService(dao, repository);
	}

	@Bean
	public CitaDeleteService citaDeleteService(CitaRepository repository, CitaDao dao)
	{
		return new CitaDeleteService(repository, dao);
	}
}
