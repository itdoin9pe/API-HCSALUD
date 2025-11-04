package com.saludsystem.submodules.catalogo.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.model.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;

@Component
public class CategoriaListHandler
{
	private final CategoriaDao categoriaDao;
	private final CategoriaMapper categoriaMapper;

	public CategoriaListHandler(CategoriaDao categoriaDao, CategoriaMapper categoriaMapper)
	{
		this.categoriaDao = categoriaDao;
		this.categoriaMapper = categoriaMapper;
	}

	public List<CategoriaDTO> execute()
	{
		List<Categoria> categoriaList = categoriaDao.getList();
		return categoriaList.stream().map(categoriaMapper::toDto).toList();
	}
}