package com.saludsystem.submodules.paciente.query.getById.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ExploracionFisicaMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.ExploracionConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ExploracionFisicaDao;

@Component
public class ExploracionFisicaByIdHandler
{
	private final ExploracionFisicaDao exploracionFisicaDao;
	private final ExploracionFisicaMapper exploracionFisicaMapper;

	public ExploracionFisicaByIdHandler(
		ExploracionFisicaDao exploracionFisicaDao,
		ExploracionFisicaMapper exploracionFisicaMapper)
	{
		this.exploracionFisicaDao = exploracionFisicaDao;
		this.exploracionFisicaMapper = exploracionFisicaMapper;
	}

	public ExploracionFisicaDTO execute(UUID uuid)
	{
		var exploracionFisica = exploracionFisicaDao.getById(uuid);
		if (exploracionFisica == null)
		{
			throw new IllegalArgumentException(ExploracionConstant.INVALID_ID);
		}
		return exploracionFisicaMapper.toDto(exploracionFisica);
	}
}