package com.saludsystem.submodules.core.paciente.adapter.beanconfig.tratamiento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.tratamiento.CostoTratamientoMapper;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.CostoTratamientoDao;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.CostoTratamientoRepository;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.costotratamiento.CostoTratamientoCreateService;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.costotratamiento.CostoTratamientoDeleteService;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.costotratamiento.CostoTratamientoEditService;

@Configuration
public class CostoTratamientoBean
{
	@Bean
	public CostoTratamientoMapper costoTratamientoMapper()
	{
		return new CostoTratamientoMapper();
	}

	@Bean
	public CostoTratamientoCreateService costoTratamientoCreateService(CostoTratamientoRepository repository)
	{
		return new CostoTratamientoCreateService(repository);
	}

	@Bean
	public CostoTratamientoEditService costoTratamientoEditService(
		CostoTratamientoDao dao,
		CostoTratamientoRepository repository)
	{
		return new CostoTratamientoEditService(dao, repository);
	}

	@Bean
	public CostoTratamientoDeleteService costoTratamientoDeleteService(
		CostoTratamientoRepository repository,
		CostoTratamientoDao dao)
	{
		return new CostoTratamientoDeleteService(repository, dao);
	}
}