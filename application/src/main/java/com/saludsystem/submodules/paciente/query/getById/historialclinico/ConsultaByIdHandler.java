package com.saludsystem.submodules.paciente.query.getById.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ConsultaMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.ConsultaConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ConsultaDTO;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ConsultaDao;

@Component
public class ConsultaByIdHandler
{
	private final ConsultaDao consultaDao;
	private final ConsultaMapper consultaMapper;

	public ConsultaByIdHandler(ConsultaDao consultaDao, ConsultaMapper consultaMapper)
	{
		this.consultaDao = consultaDao;
		this.consultaMapper = consultaMapper;
	}

	public ConsultaDTO execute(UUID uuid)
	{
		var consulta = consultaDao.getById(uuid);
		if (consulta == null)
		{
			throw new IllegalArgumentException(ConsultaConstant.INVALID_ID);
		}
		return consultaMapper.toDto(consulta);
	}
}