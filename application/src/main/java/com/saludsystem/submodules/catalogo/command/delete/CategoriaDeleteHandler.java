package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.categoria.CategoriaDeleteService;

@Component
public class CategoriaDeleteHandler
{
	private final CategoriaDeleteService categoriaDeleteService;

	public CategoriaDeleteHandler(CategoriaDeleteService categoriaDeleteService)
	{
		this.categoriaDeleteService = categoriaDeleteService;
	}

	public void execute(UUID uuid)
	{
		categoriaDeleteService.execute(uuid);
	}
}