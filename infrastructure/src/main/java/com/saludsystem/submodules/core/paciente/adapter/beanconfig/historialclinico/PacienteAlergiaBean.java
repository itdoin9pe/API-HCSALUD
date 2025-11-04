package com.saludsystem.submodules.core.paciente.adapter.beanconfig.historialclinico;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.historialclinico.PacienteAlergiaMapper;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.PacienteAlergiaDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.PacienteAlergiaRepository;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia.PacienteAlergiaCreateService;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia.PacienteAlergiaDeleteService;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia.PacienteAlergiaEditService;

@Configuration
public class PacienteAlergiaBean
{
	@Bean
	public PacienteAlergiaMapper pacienteAlergiaMapper()
	{
		return new PacienteAlergiaMapper();
	}

	@Bean
	public PacienteAlergiaCreateService pacienteAlergiaCreateService(PacienteAlergiaRepository repository)
	{
		return new PacienteAlergiaCreateService(repository);
	}

	@Bean
	public PacienteAlergiaEditService pacienteAlergiaEditService(
		PacienteAlergiaDao dao,
		PacienteAlergiaRepository repository)
	{
		return new PacienteAlergiaEditService(dao, repository);
	}

	@Bean
	public PacienteAlergiaDeleteService pacienteAlergiaDeleteService(
		PacienteAlergiaRepository repository,
		PacienteAlergiaDao dao)
	{
		return new PacienteAlergiaDeleteService(repository, dao);
	}
}