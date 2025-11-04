package com.saludsystem.submodules.mantenimiento.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.CajaCreateCommand;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaCreateService;

@Component
public class CajaCreateHandler
{
	private final CajaCreateService cajaCreateService;
	private final CajaMapper cajaMapper;

	public CajaCreateHandler(CajaCreateService cajaCreateService, CajaMapper cajaMapper)
	{
		this.cajaCreateService = cajaCreateService;
		this.cajaMapper = cajaMapper;
	}

	public void execute(CajaCreateCommand createCommand)
	{
		var caja = cajaMapper.fromCreateDto(createCommand);
		cajaCreateService.execute(caja);
	}
}