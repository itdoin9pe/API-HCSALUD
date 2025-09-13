package com.saludsystem.submodules.mantenimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaDeleteService;

@Component
public class CuentaDeleteHandler
{
	private final CuentaDeleteService cuentaDeleteService;

	public CuentaDeleteHandler(CuentaDeleteService cuentaDeleteService)
	{
		this.cuentaDeleteService = cuentaDeleteService;
	}

	public void execute(UUID uuid)
	{
		cuentaDeleteService.execute(uuid);
	}
}