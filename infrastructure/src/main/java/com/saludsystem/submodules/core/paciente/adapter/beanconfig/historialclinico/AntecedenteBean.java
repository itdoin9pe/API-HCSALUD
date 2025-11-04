package com.saludsystem.submodules.core.paciente.adapter.beanconfig.historialclinico;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.paciente.mapper.historialclinico.AntecedenteMapper;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.AntecedenteDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.AntecedenteRespository;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.antecedente.AntecedenteCreateService;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.antecedente.AntecedenteDeleteService;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.antecedente.AntecedenteEditService;

@Configuration
public class AntecedenteBean
{
	@Bean
	public AntecedenteMapper antecedenteMapper()
	{
		return new AntecedenteMapper();
	}

	@Bean
	public AntecedenteCreateService antecedenteCreateService(AntecedenteRespository respository)
	{
		return new AntecedenteCreateService(respository);
	}

	@Bean
	public AntecedenteEditService antecedenteEditService(AntecedenteDao dao, AntecedenteRespository respository)
	{
		return new AntecedenteEditService(dao, respository);
	}

	@Bean
	public AntecedenteDeleteService antecedenteDeleteService(AntecedenteRespository respository, AntecedenteDao dao)
	{
		return new AntecedenteDeleteService(respository, dao);
	}
}