package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.BancoRepository;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoCreateService;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoDeleteService;
import com.saludsystem.submodules.mantenimiento.service.banco.BancoEditService;

@Configuration
public class BancoBean
{
	@Bean
	public BancoMapper bancoMapper()
	{
		return new BancoMapper();
	}

	@Bean
	public BancoCreateService bancoCreateService(BancoRepository bancoRepository)
	{
		return new BancoCreateService(bancoRepository);
	}

	@Bean
	public BancoEditService bancoEditService(BancoDao dao, BancoRepository bancoRepository)
	{
		return new BancoEditService(dao, bancoRepository);
	}

	@Bean
	public BancoDeleteService bancoDeleteService(BancoRepository bancoRepository, BancoDao dao)
	{
		return new BancoDeleteService(bancoRepository, dao);
	}
}
