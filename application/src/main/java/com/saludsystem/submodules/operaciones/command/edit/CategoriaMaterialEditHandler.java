package com.saludsystem.submodules.operaciones.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.CategoriaMatEditCommand;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialEditService;

@Component
public class CategoriaMaterialEditHandler
{
	private final CategoriaMaterialEditService categoriaMaterialEditService;
	private final CategoriaMaterialMapper categoriaMaterialMapper;

	public CategoriaMaterialEditHandler(
		CategoriaMaterialEditService categoriaMaterialEditService,
		CategoriaMaterialMapper categoriaMaterialMapper)
	{
		this.categoriaMaterialEditService = categoriaMaterialEditService;
		this.categoriaMaterialMapper = categoriaMaterialMapper;
	}

	public void execute(UUID uuid, CategoriaMatEditCommand editCommand)
	{
		var catMaterial = categoriaMaterialMapper.fromUpdateDto(uuid, editCommand);
		categoriaMaterialEditService.execute(uuid, catMaterial);
	}
}