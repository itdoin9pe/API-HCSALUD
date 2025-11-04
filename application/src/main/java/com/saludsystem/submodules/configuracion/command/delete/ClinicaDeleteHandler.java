package com.saludsystem.submodules.configuracion.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.service.clinica.ClinicaDeleteService;

@Component
public class ClinicaDeleteHandler
{
	private final ClinicaDeleteService clinicaDeleteService;

	public ClinicaDeleteHandler(ClinicaDeleteService clinicaDeleteService)
	{
		this.clinicaDeleteService = clinicaDeleteService;
	}

	public void execute(UUID uuid)
	{
		clinicaDeleteService.execute(uuid);
	}
}