package com.saludsystem.submodules.catalogo.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.TipoCitadoEditCommand;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoEditService;

@Component
public class TipoCitadoEditHandler
{
	private final TipoCitadoEditService tipoCitadoEditService;
	private final TipoCitadoMapper tipoCitadoMapper;

	public TipoCitadoEditHandler(TipoCitadoEditService tipoCitadoEditService, TipoCitadoMapper tipoCitadoMapper)
	{
		this.tipoCitadoEditService = tipoCitadoEditService;
		this.tipoCitadoMapper = tipoCitadoMapper;
	}

	public void execute(UUID uuid, TipoCitadoEditCommand editCommand)
	{
		var tipoCitado = tipoCitadoMapper.fromUpdateDto(uuid, editCommand);
		tipoCitadoEditService.execute(uuid, tipoCitado);
	}
}