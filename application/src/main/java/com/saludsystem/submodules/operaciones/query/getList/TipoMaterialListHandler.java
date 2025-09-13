package com.saludsystem.submodules.operaciones.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.TipoMaterialMapper;
import com.saludsystem.submodules.operaciones.model.TipoMaterial;
import com.saludsystem.submodules.operaciones.model.dtos.TipoMaterialDTO;
import com.saludsystem.submodules.operaciones.port.dao.TipoMaterialDao;

@Component
public class TipoMaterialListHandler
{
	private final TipoMaterialDao tipoMaterialDao;
	private final TipoMaterialMapper tipoMaterialMapper;

	public TipoMaterialListHandler(TipoMaterialDao tipoMaterialDao, TipoMaterialMapper tipoMaterialMapper)
	{
		this.tipoMaterialDao = tipoMaterialDao;
		this.tipoMaterialMapper = tipoMaterialMapper;
	}

	public List<TipoMaterialDTO> execute()
	{
		List<TipoMaterial> tipoMaterialList = tipoMaterialDao.getList();
		return tipoMaterialList.stream().map(tipoMaterialMapper::toDto).toList();
	}
}