package com.saludsystem.submodules.paciente.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.RecetaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.RecetaEditCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.receta.RecetaEditService;

@Component
public class RecetaEditHandler
{
	private final RecetaEditService recetaEditService;
	private final RecetaMapper recetaMapper;

	public RecetaEditHandler(RecetaEditService recetaEditService, RecetaMapper recetaMapper)
	{
		this.recetaEditService = recetaEditService;
		this.recetaMapper = recetaMapper;
	}

	public void execute(UUID uuid, RecetaEditCommand editCommand)
	{
		var recetaUpdated = recetaMapper.fromUpdateDto(uuid, editCommand);
		recetaEditService.execute(uuid, recetaUpdated);
	}
}