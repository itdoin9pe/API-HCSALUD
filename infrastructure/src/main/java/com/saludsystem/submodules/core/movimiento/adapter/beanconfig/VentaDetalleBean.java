package com.saludsystem.submodules.core.movimiento.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.movimiento.mapper.VentaDetalleMapper;
import com.saludsystem.submodules.movimiento.port.dao.VentaDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.VentaDetalleRepository;
import com.saludsystem.submodules.movimiento.service.ventadetalle.VentaDetalleCreateService;
import com.saludsystem.submodules.movimiento.service.ventadetalle.VentaDetalleDeleteService;
import com.saludsystem.submodules.movimiento.service.ventadetalle.VentaDetalleEditService;

@Configuration
public class VentaDetalleBean
{
	@Bean
	public VentaDetalleMapper ventaDetalleMapper()
	{
		return new VentaDetalleMapper();
	}

	@Bean
	public VentaDetalleCreateService ventaDetalleCreateService(VentaDetalleRepository repository)
	{
		return new VentaDetalleCreateService(repository);
	}

	@Bean
	public VentaDetalleEditService ventaDetalleEditService(VentaDetalleDao dao, VentaDetalleRepository repository)
	{
		return new VentaDetalleEditService(dao, repository);
	}

	@Bean
	public VentaDetalleDeleteService ventaDetalleDeleteService(VentaDetalleRepository repository, VentaDetalleDao dao)
	{
		return new VentaDetalleDeleteService(repository, dao);
	}
}