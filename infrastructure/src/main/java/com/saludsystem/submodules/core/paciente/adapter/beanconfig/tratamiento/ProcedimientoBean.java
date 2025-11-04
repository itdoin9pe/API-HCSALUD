package com.saludsystem.submodules.core.paciente.adapter.beanconfig.tratamiento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.tratamiento.ProcedimientoMapper;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.ProcedimientoDao;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.ProcedimientoRepository;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento.ProcedimientoCreateService;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento.ProcedimientoDeleteService;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento.ProcedimientoEditService;

@Configuration
public class ProcedimientoBean
{
	@Bean
	public ProcedimientoMapper procedimientoMapper()
	{
		return new ProcedimientoMapper();
	}

	@Bean
	public ProcedimientoCreateService procedimientoCreateService(ProcedimientoRepository repository)
	{
		return new ProcedimientoCreateService(repository);
	}

	@Bean
	public ProcedimientoEditService procedimientoEditService(ProcedimientoDao dao, ProcedimientoRepository repository)
	{
		return new ProcedimientoEditService(dao, repository);
	}

	@Bean
	public ProcedimientoDeleteService procedimientoDeleteService(
		ProcedimientoRepository repository,
		ProcedimientoDao dao)
	{
		return new ProcedimientoDeleteService(repository, dao);
	}
}