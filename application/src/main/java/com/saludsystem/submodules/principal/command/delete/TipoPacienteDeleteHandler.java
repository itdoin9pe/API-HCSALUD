package com.saludsystem.submodules.principal.command.delete;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteDeleteService;

@Component
public class TipoPacienteDeleteHandler
{
	private final TipoPacienteDeleteService tipoPacienteDeleteService;

	public TipoPacienteDeleteHandler(TipoPacienteDeleteService tipoPacienteDeleteService)
	{
		this.tipoPacienteDeleteService = tipoPacienteDeleteService;
	}

	public void execute(Long id)
	{
		tipoPacienteDeleteService.execute(id);
	}
}