package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.principal.mapper.SucursalMapper;

@Configuration
public class SucursalBean
{
	@Bean
	public SucursalMapper sucursalMapper()
	{
		return new SucursalMapper();
	}
}
