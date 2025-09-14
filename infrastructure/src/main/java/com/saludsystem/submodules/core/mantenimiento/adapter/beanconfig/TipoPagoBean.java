package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoPagoRepository;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoCreateService;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoDeleteService;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoEditService;

@Configuration
public class TipoPagoBean
{
	@Bean
	public TipoPagoMapper tipoPagoMapper()
	{
		return new TipoPagoMapper();
	}

	@Bean
	public TipoPagoCreateService tipoPagoCreateService(TipoPagoRepository repository)
	{
		return new TipoPagoCreateService(repository);
	}

	@Bean
	public TipoPagoEditService tipoPagoEditService(TipoPagoDao dao, TipoPagoRepository repository)
	{
		return new TipoPagoEditService(dao, repository);
	}

	@Bean
	public TipoPagoDeleteService tipoPagoDeleteService(TipoPagoRepository repository, TipoPagoDao dao)
	{
		return new TipoPagoDeleteService(repository, dao);
	}
}
