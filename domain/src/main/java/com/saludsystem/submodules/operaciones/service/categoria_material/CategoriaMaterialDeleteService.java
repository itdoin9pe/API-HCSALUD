package com.saludsystem.submodules.operaciones.service.categoria_material;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;
import com.saludsystem.submodules.operaciones.port.repository.CategoriaMaterialRepository;

public class CategoriaMaterialDeleteService
{
	private final CategoriaMaterialRepository categoriaMaterialRepository;
	private final CategoriaMaterialDao categoriaMaterialDao;

	public CategoriaMaterialDeleteService(
		CategoriaMaterialRepository categoriaMaterialRepository,
		CategoriaMaterialDao categoriaMaterialDao)
	{
		this.categoriaMaterialRepository = categoriaMaterialRepository;
		this.categoriaMaterialDao = categoriaMaterialDao;
	}

	public void execute(UUID uuid)
	{
		var catMaterial = categoriaMaterialDao.getById(uuid);
		if (catMaterial.getEstado() != null && catMaterial.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar la categoria material , ya se encuentra desactivada");
		}
		categoriaMaterialRepository.delete(uuid);
	}
}
