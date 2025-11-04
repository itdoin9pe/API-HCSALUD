package com.saludsystem.submodules.paciente.query.getById.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.PacienteAlergiaMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.PacienteAlergiaConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.PacienteAlergiaDao;

@Component
public class PacienteAlergiaByIdHandler
{
	private final PacienteAlergiaDao pacienteAlergiaDao;
	private final PacienteAlergiaMapper pacienteAlergiaMapper;

	public PacienteAlergiaByIdHandler(
		PacienteAlergiaDao pacienteAlergiaDao,
		PacienteAlergiaMapper pacienteAlergiaMapper)
	{
		this.pacienteAlergiaDao = pacienteAlergiaDao;
		this.pacienteAlergiaMapper = pacienteAlergiaMapper;
	}

	public PacienteAlergiaDTO execute(UUID uuid)
	{
		var pacienteAlergia = pacienteAlergiaDao.getById(uuid);
		if (pacienteAlergia == null)
		{
			throw new IllegalArgumentException(PacienteAlergiaConstant.INVALID_ID);
		}
		return pacienteAlergiaMapper.toDto(pacienteAlergia);
	}
}