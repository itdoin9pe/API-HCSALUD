package com.saludsystem.submodules.configuracion.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.service.user.UserDeleteService;

@Component
public class UsuarioDeleteHandler
{
	private final UserDeleteService userDeleteService;

	public UsuarioDeleteHandler(UserDeleteService userDeleteService)
	{
		this.userDeleteService = userDeleteService;
	}

	public void execute(UUID uuid)
	{
		userDeleteService.execute(uuid);
	}
}