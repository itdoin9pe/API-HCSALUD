package com.saludsystem.submodules.paciente.service.historia.evolucion;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.evolucion.EvolucionConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;
import com.saludsystem.submodules.paciente.port.dao.evolucion.EvolucionDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.EvolucionRepository;

public class EvolucionEditService
{
	private final EvolucionDao evolucionDao;
	private final EvolucionRepository evolucionRepository;

	public EvolucionEditService(EvolucionDao evolucionDao, EvolucionRepository evolucionRepository)
	{
		this.evolucionDao = evolucionDao;
		this.evolucionRepository = evolucionRepository;
	}

	public Evolucion execute(UUID uuid, Evolucion evolucion)
	{
		var currentEvolucion = evolucionDao.getById(uuid);
		if (currentEvolucion == null)
		{
			throw new IllegalArgumentException(EvolucionConstant.INVALID_ID);
		}
		if (currentEvolucion.getFechaInicio() != null)
		{
			throw new IllegalStateException("La fecha debe ser modificada");
		}
		return evolucionRepository.update(uuid, evolucion);
	}
}
