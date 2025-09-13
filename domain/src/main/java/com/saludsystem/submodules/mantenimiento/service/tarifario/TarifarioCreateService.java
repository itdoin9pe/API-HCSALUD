package com.saludsystem.submodules.mantenimiento.service.tarifario;

import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;

public class TarifarioCreateService
{
	private final TarifarioRepository tarifarioRepository;

	public TarifarioCreateService(TarifarioRepository tarifarioRepository)
	{
		this.tarifarioRepository = tarifarioRepository;
	}

	public Tarifario execute(Tarifario tarifario)
	{
		return tarifarioRepository.save(tarifario);
	}
}
