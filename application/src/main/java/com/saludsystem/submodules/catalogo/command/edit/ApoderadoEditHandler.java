package com.saludsystem.submodules.catalogo.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ApoderadoEditCommand;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoEditService;

@Component
public class ApoderadoEditHandler
{
	private final ApoderadoEditService apoderadoEditService;
	private final ApoderadoMapper apoderadoMapper;

	public ApoderadoEditHandler(ApoderadoEditService apoderadoEditService, ApoderadoMapper apoderadoMapper)
	{
		this.apoderadoEditService = apoderadoEditService;
		this.apoderadoMapper = apoderadoMapper;
	}

	public void execute(UUID uuid, ApoderadoEditCommand editCommand)
	{
		var apoderadoUpdated = apoderadoMapper.fromUpdateDto(uuid, editCommand);
		apoderadoEditService.execute(uuid, apoderadoUpdated);
	}
}