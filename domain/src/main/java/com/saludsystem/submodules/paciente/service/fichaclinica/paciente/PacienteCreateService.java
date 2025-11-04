package com.saludsystem.submodules.paciente.service.fichaclinica.paciente;

import com.saludsystem.submodules.paciente.model.entity.Paciente;
import com.saludsystem.submodules.paciente.port.repository.PacienteRepository;

public class PacienteCreateService
{
	private final PacienteRepository pacienteRepository;

	public PacienteCreateService(PacienteRepository pacienteRepository)
	{
		this.pacienteRepository = pacienteRepository;
	}

	public Paciente execute(Paciente paciente)
	{
		return pacienteRepository.save(paciente);
	}
}
