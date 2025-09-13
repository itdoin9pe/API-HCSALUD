package com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.historialclinico.ExploracionConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ExploracionFisicaDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ExploracionFisicaRepository;

public class ExploracionFisicaEditService
{
	private final ExploracionFisicaDao exploracionFisicaDao;
	private final ExploracionFisicaRepository exploracionFisicaRepository;

	public ExploracionFisicaEditService(
		ExploracionFisicaDao exploracionFisicaDao,
		ExploracionFisicaRepository exploracionFisicaRepository)
	{
		this.exploracionFisicaDao = exploracionFisicaDao;
		this.exploracionFisicaRepository = exploracionFisicaRepository;
	}

	public ExploracionFisica execute(UUID uuid, ExploracionFisica exploracionFisica)
	{
		var currentExploracionFisica = exploracionFisicaDao.getById(uuid);
		if (currentExploracionFisica == null)
		{
			throw new IllegalArgumentException(ExploracionConstant.INVALID_ID);
		}
		if (currentExploracionFisica.getTalla() != null && currentExploracionFisica.getTalla().equals(" "))
		{
			throw new IllegalStateException("Sin talla del paciente registrada");
		}
		return exploracionFisicaRepository.update(uuid, exploracionFisica);
	}
}
