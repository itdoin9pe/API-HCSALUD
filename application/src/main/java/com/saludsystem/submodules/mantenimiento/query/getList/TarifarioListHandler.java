package com.saludsystem.submodules.mantenimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.model.dtos.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;

@Component
public class TarifarioListHandler
{
	private final TarifarioDao tarifarioDao;
	private final TarifarioMapper tarifarioMapper;

	public TarifarioListHandler(TarifarioDao tarifarioDao, TarifarioMapper tarifarioMapper)
	{
		this.tarifarioDao = tarifarioDao;
		this.tarifarioMapper = tarifarioMapper;
	}

	public List<TarifarioDTO> execute()
	{
		List<Tarifario> tarifarioList = tarifarioDao.getList();
		return tarifarioList.stream().map(tarifarioMapper::toDto).toList();
	}
}