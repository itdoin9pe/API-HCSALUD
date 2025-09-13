package com.saludsystem.submodules.principal.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.TipoPacienteMapper;
import com.saludsystem.submodules.principal.model.dtos.command.TipoPacienteCreateCommand;
import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteCreateService;

@Component
public class TipoPacienteCreateHandler
{
	private final TipoPacienteCreateService tipoPacienteCreateService;
	private final TipoPacienteMapper tipoPacienteMapper;

	public TipoPacienteCreateHandler(
		TipoPacienteCreateService tipoPacienteCreateService,
		TipoPacienteMapper tipoPacienteMapper)
	{
		this.tipoPacienteCreateService = tipoPacienteCreateService;
		this.tipoPacienteMapper = tipoPacienteMapper;
	}

	public void execute(TipoPacienteCreateCommand createCommand)
	{
		var tipoPacSaved = tipoPacienteMapper.fromCreateDto(createCommand);
		tipoPacienteCreateService.execute(tipoPacSaved);
	}
}