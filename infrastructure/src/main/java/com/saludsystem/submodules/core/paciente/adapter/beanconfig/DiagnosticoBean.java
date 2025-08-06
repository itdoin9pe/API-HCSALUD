package com.saludsystem.submodules.core.paciente.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.DiagnosticoMapper;
import com.saludsystem.submodules.paciente.port.dao.DiagnosticoDao;
import com.saludsystem.submodules.paciente.port.repository.DiagnosticoRepository;
import com.saludsystem.submodules.paciente.service.fichaclinica.diagnostico.DiagnosticoCreateService;
import com.saludsystem.submodules.paciente.service.fichaclinica.diagnostico.DiagnosticoDeleteService;
import com.saludsystem.submodules.paciente.service.fichaclinica.diagnostico.DiagnosticoEditService;

@Configuration
public class DiagnosticoBean {

	@Bean
	public DiagnosticoMapper diagnosticoMapper() {
		return new DiagnosticoMapper();
	}
	
	@Bean
	public DiagnosticoCreateService diagnosticoCreateService(DiagnosticoRepository repository) {
		
		return new DiagnosticoCreateService(repository);
		
	}
	
	@Bean
	public DiagnosticoEditService diagnosticoEditService(DiagnosticoDao dao, DiagnosticoRepository repository) {
		
		return new DiagnosticoEditService(dao, repository);
		
	}
	
	@Bean
	public DiagnosticoDeleteService diagnosticoDeleteService(DiagnosticoRepository repository, DiagnosticoDao dao) {
		
		return new DiagnosticoDeleteService(repository, dao);
		
	}

}