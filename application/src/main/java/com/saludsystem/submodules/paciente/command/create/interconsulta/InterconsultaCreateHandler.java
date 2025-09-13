package com.saludsystem.submodules.paciente.command.create.interconsulta;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InterconsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.interconsulta.InterconsultaCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.InterconsultaCreateService;

@Component
public class InterconsultaCreateHandler
{
	private final InterconsultaCreateService interconsultaCreateService;
	private final InterconsultaMapper interconsultaMapper;

	public InterconsultaCreateHandler(
		InterconsultaCreateService interconsultaCreateService,
		InterconsultaMapper interconsultaMapper)
	{
		this.interconsultaCreateService = interconsultaCreateService;
		this.interconsultaMapper = interconsultaMapper;
	}

	public void execute(InterconsultaCreateCommand createCommand)
	{
		var interconsultaSaved = interconsultaMapper.fromCreateDto(createCommand);
		interconsultaCreateService.execute(interconsultaSaved);
	}
}