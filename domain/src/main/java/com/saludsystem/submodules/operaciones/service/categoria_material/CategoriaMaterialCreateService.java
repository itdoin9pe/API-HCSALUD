package com.saludsystem.submodules.operaciones.service.categoria_material;

import com.saludsystem.submodules.operaciones.model.CategoriaMaterial;
import com.saludsystem.submodules.operaciones.port.repository.CategoriaMaterialRepository;

public class CategoriaMaterialCreateService
{
	private final CategoriaMaterialRepository categoriaMaterialRepository;

	public CategoriaMaterialCreateService(CategoriaMaterialRepository categoriaMaterialRepository)
	{
		this.categoriaMaterialRepository = categoriaMaterialRepository;
	}

	public CategoriaMaterial execute(CategoriaMaterial categoriaMaterial)
	{
		return categoriaMaterialRepository.save(categoriaMaterial);
	}
}
