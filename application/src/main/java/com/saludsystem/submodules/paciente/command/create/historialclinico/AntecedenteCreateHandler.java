package com.saludsystem.submodules.paciente.command.create.historialclinico;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.AntecedenteMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.AntecedenteCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.antecedente.AntecedenteCreateService;

@Component
public class AntecedenteCreateHandler
{
	private final AntecedenteCreateService antecedenteCreateService;
	private final AntecedenteMapper antecedenteMapper;

	public AntecedenteCreateHandler(
		AntecedenteCreateService antecedenteCreateService,
		AntecedenteMapper antecedenteMapper)
	{
		this.antecedenteCreateService = antecedenteCreateService;
		this.antecedenteMapper = antecedenteMapper;
	}

	public void execute(AntecedenteCreateCommand createCommand)
	{
		var antecedenteSaved = antecedenteMapper.fromCreateDto(createCommand);
		antecedenteCreateService.execute(antecedenteSaved);
	}
}