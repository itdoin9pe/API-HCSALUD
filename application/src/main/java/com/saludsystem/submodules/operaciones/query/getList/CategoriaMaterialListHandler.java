package com.saludsystem.submodules.operaciones.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.operaciones.model.dtos.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;

@Component
public class CategoriaMaterialListHandler
{
	private final CategoriaMaterialDao categoriaMaterialDao;
	private final CategoriaMaterialMapper categoriaMaterialMapper;

	public CategoriaMaterialListHandler(
		CategoriaMaterialDao categoriaMaterialDao,
		CategoriaMaterialMapper categoriaMaterialMapper)
	{
		this.categoriaMaterialDao = categoriaMaterialDao;
		this.categoriaMaterialMapper = categoriaMaterialMapper;
	}

	public List<CategoriaMatDTO> execute()
	{
		List<CategoriaMaterial> categoriaMaterialList = categoriaMaterialDao.getList();
		return categoriaMaterialList.stream().map(categoriaMaterialMapper::toDto).toList();
	}
}