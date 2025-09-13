package com.saludsystem.submodules.paciente.command.edit.estadocuenta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EPagoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.EPagoEditCommand;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.estadopago.EPagoEditService;

@Component
public class EPagoEditHandler
{
	private final EPagoEditService ePagoEditService;
	private final EPagoMapper ePagoMapper;

	public EPagoEditHandler(EPagoEditService ePagoEditService, EPagoMapper ePagoMapper)
	{
		this.ePagoEditService = ePagoEditService;
		this.ePagoMapper = ePagoMapper;
	}

	public void execute(UUID uuid, EPagoEditCommand editCommand)
	{
		var ePagoUpdated = ePagoMapper.fromUpdateDto(uuid, editCommand);
		ePagoEditService.execute(uuid, ePagoUpdated);
	}
}