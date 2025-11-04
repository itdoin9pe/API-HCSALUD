package com.saludsystem.submodules.paciente.query.getById.evolucion;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.evolucion.EvolucionMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.EvolucionConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.EvolucionDTO;
import com.saludsystem.submodules.paciente.port.dao.evolucion.EvolucionDao;

@Component
public class EvolucionByIdHandler
{
	private final EvolucionDao evolucionDao;
	private final EvolucionMapper evolucionMapper;

	public EvolucionByIdHandler(EvolucionDao evolucionDao, EvolucionMapper evolucionMapper)
	{
		this.evolucionDao = evolucionDao;
		this.evolucionMapper = evolucionMapper;
	}

	public EvolucionDTO execute(UUID uuid)
	{
		var evolucion = evolucionDao.getById(uuid);
		if (evolucion == null)
		{
			throw new IllegalArgumentException(EvolucionConstant.INVALID_ID);
		}
		return evolucionMapper.toDto(evolucion);
	}
}