package com.saludsystem.submodules.paciente.query.getById.tratamiento;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.tratamiento.ProcedimientoMapper;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.ProcedimientoConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.ProcedimientoDTO;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.ProcedimientoDao;

@Component
public class ProcedimientoByIdHandler
{
	private final ProcedimientoDao procedimientoDao;
	private final ProcedimientoMapper procedimientoMapper;

	public ProcedimientoByIdHandler(ProcedimientoDao procedimientoDao, ProcedimientoMapper procedimientoMapper)
	{
		this.procedimientoDao = procedimientoDao;
		this.procedimientoMapper = procedimientoMapper;
	}

	public ProcedimientoDTO execute(UUID uuid)
	{
		var procedimiento = procedimientoDao.getById(uuid);
		if (procedimiento == null)
		{
			throw new IllegalArgumentException(ProcedimientoConstant.INVALID_ID);
		}
		return procedimientoMapper.toDto(procedimiento);
	}
}