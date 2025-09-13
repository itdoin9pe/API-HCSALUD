package com.saludsystem.submodules.paciente.command.delete.estadocuenta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.estadocuenta.EstadoCuentaDeleteService;

@Component
public class EstadoCuentaDeleteHandler
{
	private final EstadoCuentaDeleteService estadoCuentaDeleteService;

	public EstadoCuentaDeleteHandler(EstadoCuentaDeleteService estadoCuentaDeleteService)
	{
		this.estadoCuentaDeleteService = estadoCuentaDeleteService;
	}

	public void execute(UUID uuid)
	{
		estadoCuentaDeleteService.execute(uuid);
	}
}