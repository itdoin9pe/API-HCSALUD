package com.saludsystem.submodules.catalogo.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.ApoderadoCreateCommand;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoCreateService;

@Component
public class ApoderadoCreateHandler
{
	private final ApoderadoCreateService apoderadoCreateService;
	private final ApoderadoMapper apoderadoMapper;

	public ApoderadoCreateHandler(ApoderadoCreateService apoderadoCreateService, ApoderadoMapper apoderadoMapper)
	{
		this.apoderadoCreateService = apoderadoCreateService;
		this.apoderadoMapper = apoderadoMapper;
	}

	public void execute(ApoderadoCreateCommand dto)
	{
		var apoderado = apoderadoMapper.fromCreateDto(dto);
		apoderadoCreateService.execute(apoderado);
	}
}