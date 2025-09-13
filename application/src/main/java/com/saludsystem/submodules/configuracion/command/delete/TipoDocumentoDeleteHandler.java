package com.saludsystem.submodules.configuracion.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.service.tipodocumento.TipoDocumentoDeleteService;

@Component
public class TipoDocumentoDeleteHandler
{
	private final TipoDocumentoDeleteService tipoDocumentoDeleteService;

	public TipoDocumentoDeleteHandler(TipoDocumentoDeleteService tipoDocumentoDeleteService)
	{
		this.tipoDocumentoDeleteService = tipoDocumentoDeleteService;
	}

	public void execute(UUID uuid)
	{
		tipoDocumentoDeleteService.execute(uuid);
	}
}