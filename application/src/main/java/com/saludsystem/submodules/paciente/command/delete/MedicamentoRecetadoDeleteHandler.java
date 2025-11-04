package com.saludsystem.submodules.paciente.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.fichaclinica.medicamentorecetado.MedicamentoRecetadoDeleteService;

@Component
public class MedicamentoRecetadoDeleteHandler
{
	private final MedicamentoRecetadoDeleteService medicamentoRecetadoDeleteService;

	public MedicamentoRecetadoDeleteHandler(MedicamentoRecetadoDeleteService medicamentoRecetadoDeleteService)
	{
		this.medicamentoRecetadoDeleteService = medicamentoRecetadoDeleteService;
	}

	public void execute(UUID uuid)
	{
		medicamentoRecetadoDeleteService.execute(uuid);
	}
}