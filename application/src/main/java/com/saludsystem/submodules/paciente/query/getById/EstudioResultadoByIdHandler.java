package com.saludsystem.submodules.paciente.query.getById;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.EstudioResultadoMapper;
import com.saludsystem.submodules.paciente.model.constant.EstudioResultadoConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.EstudioResultadoDTO;
import com.saludsystem.submodules.paciente.port.dao.EstudioResultadoDao;

@Component
public class EstudioResultadoByIdHandler
{
	private final EstudioResultadoDao estudioResultadoDao;
	private final EstudioResultadoMapper estudioResultadoMapper;

	public EstudioResultadoByIdHandler(
		EstudioResultadoDao estudioResultadoDao,
		EstudioResultadoMapper estudioResultadoMapper)
	{
		this.estudioResultadoDao = estudioResultadoDao;
		this.estudioResultadoMapper = estudioResultadoMapper;
	}

	public EstudioResultadoDTO execute(Long id)
	{
		var estudioResultado = estudioResultadoDao.getById(id);
		if (estudioResultado == null)
		{
			throw new IllegalArgumentException(EstudioResultadoConstant.INVALID_ID);
		}
		return estudioResultadoMapper.toDto(estudioResultado);
	}
}