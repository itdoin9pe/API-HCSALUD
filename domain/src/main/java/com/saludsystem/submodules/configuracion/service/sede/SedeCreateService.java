package com.saludsystem.submodules.configuracion.service.sede;

import com.saludsystem.submodules.configuracion.model.Sede;
import com.saludsystem.submodules.configuracion.port.in.repository.SedeRepository;

public class SedeCreateService
{
	private final SedeRepository sedeRepository;

	public SedeCreateService(SedeRepository sedeRepository)
	{
		this.sedeRepository = sedeRepository;
	}

	public Sede execute(Sede sede)
	{
		return sedeRepository.save(sede);
	}
}