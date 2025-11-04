package com.saludsystem.submodules.paciente.command.create.historialclinico;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.PacienteAlergiaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.PacienteAlergiaCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia.PacienteAlergiaCreateService;

@Component
public class PacienteAlergiaCreateHandler
{
	private final PacienteAlergiaCreateService pacienteAlergiaCreateService;
	private final PacienteAlergiaMapper pacienteAlergiaMapper;

	public PacienteAlergiaCreateHandler(
		PacienteAlergiaCreateService pacienteAlergiaCreateService,
		PacienteAlergiaMapper pacienteAlergiaMapper)
	{
		this.pacienteAlergiaCreateService = pacienteAlergiaCreateService;
		this.pacienteAlergiaMapper = pacienteAlergiaMapper;
	}

	public void execute(PacienteAlergiaCreateCommand createCommand)
	{
		var pacienteAlergiaSaved = pacienteAlergiaMapper.fromCreateDto(createCommand);
		pacienteAlergiaCreateService.execute(pacienteAlergiaSaved);
	}
}