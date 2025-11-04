package com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico;

import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;
import com.saludsystem.submodules.paciente.port.repository.EstudioMedicoRepository;

public class EstudioMedicoCreateService
{
	private final EstudioMedicoRepository estudioMedicoRepository;

	public EstudioMedicoCreateService(EstudioMedicoRepository estudioMedicoRepository)
	{
		this.estudioMedicoRepository = estudioMedicoRepository;
	}

	public EstudioMedico execute(EstudioMedico estudioMedico)
	{
		return estudioMedicoRepository.save(estudioMedico);
	}
}
