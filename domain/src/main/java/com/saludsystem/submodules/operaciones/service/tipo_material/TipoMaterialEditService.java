package com.saludsystem.submodules.operaciones.service.tipo_material;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.TipoMaterial;
import com.saludsystem.submodules.operaciones.port.dao.TipoMaterialDao;
import com.saludsystem.submodules.operaciones.port.repository.TipoMaterialRepository;

public class TipoMaterialEditService
{
	private final TipoMaterialDao tipoMaterialDao;
	private final TipoMaterialRepository tipoMaterialRepository;

	public TipoMaterialEditService(TipoMaterialDao tipoMaterialDao, TipoMaterialRepository tipoMaterialRepository)
	{
		this.tipoMaterialDao = tipoMaterialDao;
		this.tipoMaterialRepository = tipoMaterialRepository;
	}

	public TipoMaterial execute(UUID uuid, TipoMaterial tipoMaterial)
	{
		var currentTipoMaterial = tipoMaterialDao.getById(uuid);
		if (currentTipoMaterial.getEstado() != null && currentTipoMaterial.getEstado() == 0)
		{
			throw new IllegalStateException("El tipo material ya se encuentra desactivado");
		}
		return tipoMaterialRepository.update(uuid, tipoMaterial);

	}
}
