package com.saludsystem.submodules.paciente.query.getById.interconsulta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InterconsultaMapper;
import com.saludsystem.submodules.paciente.model.constant.interconsulta.InterconsultaConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InterconsultaDTO;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InterconsultaDao;

@Component
public class InterconsultaByIdHandler
{
	private final InterconsultaDao interconsultaDao;
	private final InterconsultaMapper interconsultaMapper;

	public InterconsultaByIdHandler(InterconsultaDao interconsultaDao, InterconsultaMapper interconsultaMapper)
	{
		this.interconsultaDao = interconsultaDao;
		this.interconsultaMapper = interconsultaMapper;
	}

	public InterconsultaDTO execute(UUID uuid)
	{
		var interconsulta = interconsultaDao.getById(uuid);
		if (interconsulta == null)
		{
			throw new IllegalArgumentException(InterconsultaConstant.INVALID_ID);
		}
		return interconsultaMapper.toDto(interconsulta);
	}
}