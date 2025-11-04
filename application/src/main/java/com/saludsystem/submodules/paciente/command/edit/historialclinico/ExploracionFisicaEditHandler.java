package com.saludsystem.submodules.paciente.command.edit.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ExploracionFisicaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.ExploracionFisicaEditCommand;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica.ExploracionFisicaEditService;

@Component
public class ExploracionFisicaEditHandler
{
	private final ExploracionFisicaEditService exploracionFisicaEditService;
	private final ExploracionFisicaMapper exploracionFisicaMapper;

	public ExploracionFisicaEditHandler(
		ExploracionFisicaEditService exploracionFisicaEditService,
		ExploracionFisicaMapper exploracionFisicaMapper)
	{
		this.exploracionFisicaEditService = exploracionFisicaEditService;
		this.exploracionFisicaMapper = exploracionFisicaMapper;
	}

	public void execute(UUID uuid, ExploracionFisicaEditCommand editCommand)
	{
		var exploracionFisicaUpdated = exploracionFisicaMapper.fromUpdateDto(uuid, editCommand);
		exploracionFisicaEditService.execute(uuid, exploracionFisicaUpdated);
	}
}