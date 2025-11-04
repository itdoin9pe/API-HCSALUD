package com.saludsystem.submodules.mantenimiento.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.CajaEditCommand;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaEditService;

@Component
public class CajaEditHandler
{
	private final CajaEditService cajaEditService;
	private final CajaMapper cajaMapper;

	public CajaEditHandler(CajaEditService cajaEditService, CajaMapper cajaMapper)
	{
		this.cajaEditService = cajaEditService;
		this.cajaMapper = cajaMapper;
	}

	public void execute(UUID uuid, CajaEditCommand editCommand)
	{
		var caja = cajaMapper.fromUpdateDto(uuid, editCommand);
		cajaEditService.execute(uuid, caja);
	}
}