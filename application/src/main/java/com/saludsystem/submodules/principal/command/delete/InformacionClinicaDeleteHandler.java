package com.saludsystem.submodules.principal.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaDeleteService;

@Component
public class InformacionClinicaDeleteHandler
{
	private final InformacionClinicaDeleteService informacionClinicaDeleteService;

	public InformacionClinicaDeleteHandler(InformacionClinicaDeleteService informacionClinicaDeleteService)
	{
		this.informacionClinicaDeleteService = informacionClinicaDeleteService;
	}

	public void execute(UUID uuid)
	{
		informacionClinicaDeleteService.execute(uuid);
	}
}