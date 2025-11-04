package com.saludsystem.submodules.principal.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.model.dtos.command.edit.AseguradoraEditCommand;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraEdiService;

@Component
public class AseguradoraEditHandler
{
	private final AseguradoraEdiService aseguradoraEdiService;
	private final AseguradoraMapper aseguradoraMapper;

	public AseguradoraEditHandler(AseguradoraEdiService aseguradoraEdiService, AseguradoraMapper aseguradoraMapper)
	{
		this.aseguradoraEdiService = aseguradoraEdiService;
		this.aseguradoraMapper = aseguradoraMapper;
	}

	public void execute(UUID uuid, AseguradoraEditCommand editCommand)
	{
		var aseguradoraUpdate = aseguradoraMapper.fromUpdateDto(uuid, editCommand);
		aseguradoraEdiService.execute(uuid, aseguradoraUpdate);
	}
}