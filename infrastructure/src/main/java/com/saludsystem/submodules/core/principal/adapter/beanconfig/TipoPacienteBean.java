package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.principal.mapper.TipoPacienteMapper;
import com.saludsystem.submodules.principal.port.dao.TipoPacienteDao;
import com.saludsystem.submodules.principal.port.repository.TipoPacienteRepository;
import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteCreateService;
import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteDeleteService;
import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteEditService;

@Configuration
public class TipoPacienteBean
{
	@Bean
	public TipoPacienteMapper tipoPacienteMapper()
	{
		return new TipoPacienteMapper();
	}

	@Bean
	public TipoPacienteCreateService tipoPacienteCreateService(TipoPacienteRepository repository)
	{
		return new TipoPacienteCreateService(repository);
	}

	@Bean
	public TipoPacienteEditService tipoPacienteEditService(TipoPacienteDao dao, TipoPacienteRepository repository)
	{
		return new TipoPacienteEditService(dao, repository);
	}

	@Bean
	public TipoPacienteDeleteService tipoPacienteDeleteService(TipoPacienteRepository repository, TipoPacienteDao dao)
	{
		return new TipoPacienteDeleteService(repository, dao);
	}
}
