package com.saludsystem.submodules.operaciones.service.tipo_material;

import com.saludsystem.submodules.operaciones.model.TipoMaterial;
import com.saludsystem.submodules.operaciones.port.repository.TipoMaterialRepository;

public class TipoMaterialCreateService
{
	private final TipoMaterialRepository tipoMaterialRepository;

	public TipoMaterialCreateService(TipoMaterialRepository tipoMaterialRepository)
	{
		this.tipoMaterialRepository = tipoMaterialRepository;
	}

	public TipoMaterial execute(TipoMaterial tipoMaterial)
	{
		return tipoMaterialRepository.save(tipoMaterial);
	}
}
