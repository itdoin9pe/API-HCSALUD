package com.saludsystem.submodules.core.operaciones.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.operaciones.mapper.ProveedorMapper;
import com.saludsystem.submodules.operaciones.port.dao.ProveedorDao;
import com.saludsystem.submodules.operaciones.port.repository.ProveedorRepository;
import com.saludsystem.submodules.operaciones.service.proveedor.ProveedorCreateService;
import com.saludsystem.submodules.operaciones.service.proveedor.ProveedorDeleteService;
import com.saludsystem.submodules.operaciones.service.proveedor.ProveedorEditService;

@Configuration
public class ProveedorBean
{
	@Bean
	public ProveedorMapper proveedorMapper()
	{
		return new ProveedorMapper();
	}

	@Bean
	public ProveedorCreateService proveedorCreateService(ProveedorRepository repository)
	{
		return new ProveedorCreateService(repository);
	}

	@Bean
	public ProveedorEditService proveedorEditService(ProveedorDao dao, ProveedorRepository repository)
	{
		return new ProveedorEditService(dao, repository);
	}

	@Bean
	public ProveedorDeleteService proveedorDeleteService(ProveedorRepository repository, ProveedorDao dao)
	{
		return new ProveedorDeleteService(repository, dao);
	}
}
