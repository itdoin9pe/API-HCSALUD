package com.saludsystem.submodules.core.paciente.adapter.beanconfig.evolucion;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.evolucion.EvolucionMapper;
import com.saludsystem.submodules.paciente.port.dao.evolucion.EvolucionDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.EvolucionRepository;
import com.saludsystem.submodules.paciente.service.historia.evolucion.EvolucionCreateService;
import com.saludsystem.submodules.paciente.service.historia.evolucion.EvolucionDeleteService;
import com.saludsystem.submodules.paciente.service.historia.evolucion.EvolucionEditService;

@Component
public class EvolucionBean
{
	@Bean
	public EvolucionMapper evolucionMapper()
	{
		return new EvolucionMapper();
	}

	@Bean
	public EvolucionCreateService evolucionCreateService(EvolucionRepository repository)
	{
		return new EvolucionCreateService(repository);
	}

	@Bean
	public EvolucionEditService evolucionEditService(EvolucionDao dao, EvolucionRepository repository)
	{
		return new EvolucionEditService(dao, repository);
	}

	@Bean
	public EvolucionDeleteService evolucionDeleteService(EvolucionRepository repository, EvolucionDao dao)
	{
		return new EvolucionDeleteService(repository, dao);
	}
}