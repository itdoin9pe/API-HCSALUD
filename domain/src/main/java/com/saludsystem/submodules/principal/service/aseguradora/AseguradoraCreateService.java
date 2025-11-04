package com.saludsystem.submodules.principal.service.aseguradora;

import com.saludsystem.submodules.principal.model.Aseguradora;
import com.saludsystem.submodules.principal.port.repository.AseguradoraRepository;

public class AseguradoraCreateService
{
	private final AseguradoraRepository aseguradoraRepository;

	public AseguradoraCreateService(AseguradoraRepository aseguradoraRepository)
	{
		this.aseguradoraRepository = aseguradoraRepository;
	}

	public Aseguradora execute(Aseguradora aseguradora)
	{
		return aseguradoraRepository.save(aseguradora);
	}
}
