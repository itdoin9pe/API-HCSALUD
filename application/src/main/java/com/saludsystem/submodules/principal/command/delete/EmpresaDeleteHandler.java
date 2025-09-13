package com.saludsystem.submodules.principal.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.service.empresa.EmpresaDeleteService;

@Component
public class EmpresaDeleteHandler
{
	private final EmpresaDeleteService empresaDeleteService;

	public EmpresaDeleteHandler(EmpresaDeleteService empresaDeleteService)
	{
		this.empresaDeleteService = empresaDeleteService;
	}

	public void execute(UUID uuid)
	{
		empresaDeleteService.execute(uuid);
	}
}