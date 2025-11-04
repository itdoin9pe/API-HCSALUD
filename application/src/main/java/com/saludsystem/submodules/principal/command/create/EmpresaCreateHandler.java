package com.saludsystem.submodules.principal.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.model.dtos.command.EmpresaCreateCommand;
import com.saludsystem.submodules.principal.service.empresa.EmpresaCreateService;

@Component
public class EmpresaCreateHandler
{
	private final EmpresaCreateService empresaCreateService;
	private final EmpresaMapper empresaMapper;

	public EmpresaCreateHandler(EmpresaCreateService empresaCreateService, EmpresaMapper empresaMapper)
	{
		this.empresaCreateService = empresaCreateService;
		this.empresaMapper = empresaMapper;
	}

	public void execute(EmpresaCreateCommand createCommand)
	{
		var empresaSaved = empresaMapper.fromCreateDto(createCommand);
		empresaCreateService.execute(empresaSaved);
	}
}