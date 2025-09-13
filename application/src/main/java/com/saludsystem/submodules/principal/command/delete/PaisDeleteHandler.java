package com.saludsystem.submodules.principal.command.delete;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.service.pais.PaisDeleteService;

@Component
public class PaisDeleteHandler
{
	private final PaisDeleteService paisDeleteService;

	public PaisDeleteHandler(PaisDeleteService paisDeleteService)
	{
		this.paisDeleteService = paisDeleteService;
	}

	public void execute(Integer id)
	{
		paisDeleteService.execute(id);
	}
}