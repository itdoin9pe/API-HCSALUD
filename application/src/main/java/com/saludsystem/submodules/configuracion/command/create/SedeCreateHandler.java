package com.saludsystem.submodules.configuracion.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.SedeMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.SedeCreateCommand;
import com.saludsystem.submodules.configuracion.service.sede.SedeCreateService;

@Component
public class SedeCreateHandler
{
	private final SedeCreateService sedeCreateService;
	private final SedeMapper sedeMapper;

	public SedeCreateHandler(SedeCreateService sedeCreateService, SedeMapper sedeMapper)
	{
		this.sedeCreateService = sedeCreateService;
		this.sedeMapper = sedeMapper;
	}

	public void execute(SedeCreateCommand createCommand)
	{
		var sedeSaved = sedeMapper.fromCreateDto(createCommand);
		sedeCreateService.execute(sedeSaved);
	}
}