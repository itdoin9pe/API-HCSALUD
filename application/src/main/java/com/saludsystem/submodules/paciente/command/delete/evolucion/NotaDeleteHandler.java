package com.saludsystem.submodules.paciente.command.delete.evolucion;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.evolucion.nota.NotaDeleteService;

@Component
public class NotaDeleteHandler
{
	private final NotaDeleteService notaDeleteService;

	public NotaDeleteHandler(NotaDeleteService notaDeleteService)
	{
		this.notaDeleteService = notaDeleteService;
	}

	public void execute(Long id)
	{
		notaDeleteService.execute(id);
	}
}