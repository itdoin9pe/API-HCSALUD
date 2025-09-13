package com.saludsystem.submodules.paciente.command.delete.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia.PacienteAlergiaDeleteService;

@Component
public class PacienteAlergiaDeleteHandler
{
	private final PacienteAlergiaDeleteService pacienteAlergiaDeleteService;

	public PacienteAlergiaDeleteHandler(PacienteAlergiaDeleteService pacienteAlergiaDeleteService)
	{
		this.pacienteAlergiaDeleteService = pacienteAlergiaDeleteService;
	}

	public void execute(UUID uuid)
	{
		pacienteAlergiaDeleteService.execute(uuid);
	}
}