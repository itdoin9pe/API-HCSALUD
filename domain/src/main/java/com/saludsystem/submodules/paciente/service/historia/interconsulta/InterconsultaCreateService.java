package com.saludsystem.submodules.paciente.service.historia.interconsulta;

import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InterconsultaRepository;

public class InterconsultaCreateService
{
	private final InterconsultaRepository interconsultaRepository;

	public InterconsultaCreateService(InterconsultaRepository interconsultaRepository)
	{
		this.interconsultaRepository = interconsultaRepository;
	}

	public Interconsulta execute(Interconsulta interconsulta)
	{
		return interconsultaRepository.save(interconsulta);
	}
}
