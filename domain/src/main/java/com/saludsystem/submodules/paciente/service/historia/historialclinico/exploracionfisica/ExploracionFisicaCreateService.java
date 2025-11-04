package com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ExploracionFisicaRepository;

public class ExploracionFisicaCreateService
{
	private final ExploracionFisicaRepository exploracionFisicaRepository;

	public ExploracionFisicaCreateService(ExploracionFisicaRepository exploracionFisicaRepository)
	{
		this.exploracionFisicaRepository = exploracionFisicaRepository;
	}

	public ExploracionFisica execute(ExploracionFisica exploracionFisica)
	{
		return exploracionFisicaRepository.save(exploracionFisica);
	}
}
