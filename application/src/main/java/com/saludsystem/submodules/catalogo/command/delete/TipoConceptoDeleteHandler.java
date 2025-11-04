package com.saludsystem.submodules.catalogo.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoDeleteService;

@Component
public class TipoConceptoDeleteHandler
{
	private final TipoConceptoDeleteService tipoConceptoDeleteService;

	public TipoConceptoDeleteHandler(TipoConceptoDeleteService tipoConceptoDeleteService)
	{
		this.tipoConceptoDeleteService = tipoConceptoDeleteService;
	}

	public void execute(UUID uuid)
	{
		tipoConceptoDeleteService.execute(uuid);
	}
}