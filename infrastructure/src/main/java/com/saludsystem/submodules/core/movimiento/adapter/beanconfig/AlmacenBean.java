package com.saludsystem.submodules.core.movimiento.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.movimiento.mapper.AlmacenMapper;
import com.saludsystem.submodules.movimiento.port.dao.AlmacenDao;
import com.saludsystem.submodules.movimiento.port.repository.AlmacenRepository;
import com.saludsystem.submodules.movimiento.service.almacen.AlmacenCreateService;
import com.saludsystem.submodules.movimiento.service.almacen.AlmacenDeleteService;
import com.saludsystem.submodules.movimiento.service.almacen.AlmacenEditService;

@Configuration
public class AlmacenBean {

	@Bean   
	public AlmacenMapper almacenMapper() {
		return new AlmacenMapper();
	}
	
	@Bean
	public AlmacenCreateService almacenCreateService(AlmacenRepository repository) {
		return new AlmacenCreateService(repository);
	}
	
	@Bean
	public AlmacenEditService almacenEditService(AlmacenDao dao, AlmacenRepository repository) {
		return new AlmacenEditService(dao, repository);
	}
	
	@Bean
	public AlmacenDeleteService almacenDeleteService(AlmacenRepository repository, AlmacenDao dao) {
		return new AlmacenDeleteService(repository, dao);
	}
	
}
