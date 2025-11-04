package com.saludsystem.submodules.catalogo.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.CategoriaEditCommand;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaEditService;

@Component
public class CategoriaEditHandler
{
	private final CategoriaEditService categoriaEditService;
	private final CategoriaMapper categoriaMapper;

	public CategoriaEditHandler(CategoriaEditService categoriaEditService, CategoriaMapper categoriaMapper)
	{
		this.categoriaEditService = categoriaEditService;
		this.categoriaMapper = categoriaMapper;
	}

	public void execute(UUID uuid, CategoriaEditCommand dto)
	{
		var categoria = categoriaMapper.fromUpdateDto(uuid, dto);
		categoriaEditService.execute(uuid, categoria);
	}
}