package com.saludsystem.submodules.mantenimiento.service.tarifario;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;

public class TarifarioDeleteService
{
	private final TarifarioRepository tarifarioRepository;
	private final TarifarioDao tarifarioDao;

	public TarifarioDeleteService(TarifarioRepository tarifarioRepository, TarifarioDao tarifarioDao)
	{
		this.tarifarioRepository = tarifarioRepository;
		this.tarifarioDao = tarifarioDao;
	}

	public void execute(UUID uuid)
	{
		var tarifario = tarifarioDao.getById(uuid);
		if (tarifario.getEstado() != null && tarifario.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un tipo de tarifario ya desactivado");
		}
		tarifarioRepository.delete(uuid);
	}
}
