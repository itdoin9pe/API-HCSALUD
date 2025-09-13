package com.saludsystem.submodules.catalogo.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.TipoConceptoEditCommand;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoEditService;

@Component
public class TipoConceptoEditHandler
{
	private final TipoConceptoEditService tipoConceptoEditService;
	private final TipoConceptoMapper tipoConceptoMapper;

	public TipoConceptoEditHandler(
		TipoConceptoEditService tipoConceptoEditService,
		TipoConceptoMapper tipoConceptoMapper)
	{
		this.tipoConceptoEditService = tipoConceptoEditService;
		this.tipoConceptoMapper = tipoConceptoMapper;
	}

	public void execute(UUID uuid, TipoConceptoEditCommand editCommand)
	{
		var tipoConcepto = tipoConceptoMapper.fromUpdateDto(uuid, editCommand);
		tipoConceptoEditService.execute(uuid, tipoConcepto);
	}
}