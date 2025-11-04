package com.saludsystem.submodules.mantenimiento.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.MonedaCreateCommand;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaCreateService;

@Component
public class MonedaCreateHandler
{
	private final MonedaCreateService monedaCreateService;
	private final MonedaMapper monedaMapper;

	public MonedaCreateHandler(MonedaCreateService monedaCreateService, MonedaMapper monedaMapper)
	{
		this.monedaCreateService = monedaCreateService;
		this.monedaMapper = monedaMapper;
	}

	public void execute(MonedaCreateCommand createCommand)
	{
		var moneda = monedaMapper.fromCreateDto(createCommand);
		monedaCreateService.execute(moneda);
	}
}