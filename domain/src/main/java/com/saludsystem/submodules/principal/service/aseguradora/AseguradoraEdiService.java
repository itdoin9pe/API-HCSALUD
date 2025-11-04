package com.saludsystem.submodules.principal.service.aseguradora;

import java.util.UUID;

import com.saludsystem.submodules.principal.model.Aseguradora;
import com.saludsystem.submodules.principal.model.constant.AseguradoraConstant;
import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;
import com.saludsystem.submodules.principal.port.repository.AseguradoraRepository;

public class AseguradoraEdiService
{
	private final AseguradoraDao aseguradoraDao;
	private final AseguradoraRepository aseguradoraRepository;

	public AseguradoraEdiService(AseguradoraDao aseguradoraDao, AseguradoraRepository aseguradoraRepository)
	{
		this.aseguradoraDao = aseguradoraDao;
		this.aseguradoraRepository = aseguradoraRepository;
	}

	public Aseguradora execute(UUID uuid, Aseguradora aseguradora)
	{
		var currentAseguradora = aseguradoraDao.getById(uuid);
		if (currentAseguradora == null)
		{
			throw new IllegalArgumentException(AseguradoraConstant.ID_NOT_FOUND);
		}
		if (currentAseguradora.getEstado() != null && currentAseguradora.getEstado() == 0)
		{
			throw new IllegalArgumentException("La aseguradora ya se encuentra desactivada");
		}
		return aseguradoraRepository.update(uuid, aseguradora);
	}
}
