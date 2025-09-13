package com.saludsystem.submodules.configuracion.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.RolMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.RolCreateCommand;
import com.saludsystem.submodules.configuracion.service.rol.RolCreateService;

@Component
public class RolCreateHandler
{
	private final RolCreateService rolCreateService;
	private final RolMapper rolMapper;

	public RolCreateHandler(RolCreateService rolCreateService, RolMapper rolMapper)
	{
		this.rolCreateService = rolCreateService;
		this.rolMapper = rolMapper;
	}

	public void execute(RolCreateCommand createCommand)
	{
		var rolSaved = rolMapper.fromCreateDto(createCommand);
		rolCreateService.execute(rolSaved);
	}
}