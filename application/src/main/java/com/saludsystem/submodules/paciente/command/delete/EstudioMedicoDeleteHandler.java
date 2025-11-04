package com.saludsystem.submodules.paciente.command.delete;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico.EstudioMedicoDeleteService;

@Component
public class EstudioMedicoDeleteHandler
{
	private final EstudioMedicoDeleteService estudioMedicoDeleteService;

	public EstudioMedicoDeleteHandler(EstudioMedicoDeleteService estudioMedicoDeleteService)
	{
		this.estudioMedicoDeleteService = estudioMedicoDeleteService;
	}

	public void execute(Long id)
	{
		estudioMedicoDeleteService.execute(id);
	}
}