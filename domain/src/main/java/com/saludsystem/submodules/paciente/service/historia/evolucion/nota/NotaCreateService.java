package com.saludsystem.submodules.paciente.service.historia.evolucion.nota;

import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;
import com.saludsystem.submodules.paciente.port.repository.evolucion.NotaRepository;

public class NotaCreateService
{
	private final NotaRepository notaRepository;

	public NotaCreateService(NotaRepository notaRepository)
	{
		this.notaRepository = notaRepository;
	}

	public Nota execute(Nota nota)
	{
		return notaRepository.save(nota);
	}
}
