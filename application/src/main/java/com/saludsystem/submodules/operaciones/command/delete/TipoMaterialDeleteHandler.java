package com.saludsystem.submodules.operaciones.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.service.tipo_material.TipoMaterialDeleteService;

@Component
public class TipoMaterialDeleteHandler
{
	private final TipoMaterialDeleteService tipoMaterialDeleteService;

	public TipoMaterialDeleteHandler(TipoMaterialDeleteService tipoMaterialDeleteService)
	{
		this.tipoMaterialDeleteService = tipoMaterialDeleteService;
	}

	public void execute(UUID uuid)
	{
		tipoMaterialDeleteService.execute(uuid);
	}
}