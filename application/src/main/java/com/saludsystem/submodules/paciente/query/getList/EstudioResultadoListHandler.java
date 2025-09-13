package com.saludsystem.submodules.paciente.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.EstudioResultadoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.EstudioResultadoDTO;
import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;
import com.saludsystem.submodules.paciente.port.dao.EstudioResultadoDao;

@Component
public class EstudioResultadoListHandler
{
	private final EstudioResultadoDao estudioResultadoDao;
	private final EstudioResultadoMapper estudioResultadoMapper;

	public EstudioResultadoListHandler(
		EstudioResultadoDao estudioResultadoDao,
		EstudioResultadoMapper estudioResultadoMapper)
	{
		this.estudioResultadoDao = estudioResultadoDao;
		this.estudioResultadoMapper = estudioResultadoMapper;
	}

	public List<EstudioResultadoDTO> execute()
	{
		List<EstudioResultado> estudioResultadoList = estudioResultadoDao.getList();
		return estudioResultadoList.stream().map(estudioResultadoMapper::toDto).toList();
	}
}