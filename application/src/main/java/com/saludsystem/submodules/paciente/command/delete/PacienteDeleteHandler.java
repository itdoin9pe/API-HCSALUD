package com.saludsystem.submodules.paciente.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.fichaclinica.paciente.PacienteDeleteService;

@Component
public class PacienteDeleteHandler
{
	private final PacienteDeleteService pacienteDeleteService;

	public PacienteDeleteHandler(PacienteDeleteService pacienteDeleteService)
	{
		this.pacienteDeleteService = pacienteDeleteService;
	}

	public void execute(UUID uuid)
	{
		pacienteDeleteService.execute(uuid);
	}
}