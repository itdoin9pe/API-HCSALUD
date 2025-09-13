package com.saludsystem.submodules.catalogo.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.TipoCitadoCreateCommand;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoCreateService;

@Component
public class TipoCitadoCreateHandler
{
	private final TipoCitadoCreateService tipoCitadoCreateService;
	private final TipoCitadoMapper tipoCitadoMapper;

	public TipoCitadoCreateHandler(TipoCitadoCreateService tipoCitadoCreateService, TipoCitadoMapper tipoCitadoMapper)
	{
		this.tipoCitadoCreateService = tipoCitadoCreateService;
		this.tipoCitadoMapper = tipoCitadoMapper;
	}

	public void execute(TipoCitadoCreateCommand createCommand)
	{
		var tipoCitado = tipoCitadoMapper.formCreatoDto(createCommand);
		tipoCitadoCreateService.execute(tipoCitado);
	}
}