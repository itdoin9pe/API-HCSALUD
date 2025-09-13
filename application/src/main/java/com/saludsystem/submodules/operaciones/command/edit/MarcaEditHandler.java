package com.saludsystem.submodules.operaciones.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.MarcaEditCommand;
import com.saludsystem.submodules.operaciones.service.marca.MarcaEditService;

@Component
public class MarcaEditHandler
{
	private final MarcaEditService marcaEditService;
	private final MarcaMapper marcaMapper;

	public MarcaEditHandler(MarcaEditService marcaEditService, MarcaMapper marcaMapper)
	{
		this.marcaEditService = marcaEditService;
		this.marcaMapper = marcaMapper;
	}

	public void execute(UUID uuid, MarcaEditCommand editCommand)
	{
		var marca = marcaMapper.fromUpdateDto(uuid, editCommand);
		marcaEditService.execute(uuid, marca);
	}
}