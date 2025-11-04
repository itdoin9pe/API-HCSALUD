package com.saludsystem.submodules.paciente.mapper.estadocuenta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.EPagoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.EPagoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EPagoDTO;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;

public class EPagoMapper
{
	public EPago fromCreateDto(EPagoCreateCommand createCommand)
	{
		return new EPago(null, createCommand.getPacEstadoCuentaId(), createCommand.getFechaPago(),
				createCommand.getMonto(), createCommand.getMetodoPago(), createCommand.getReferenciaPago());
	}

	public EPago fromUpdateDto(UUID uuid, EPagoEditCommand editCommand)
	{
		return new EPago(uuid, editCommand.getPacEstadoCuentaId(), editCommand.getFechaPago(), editCommand.getMonto(),
				editCommand.getMetodoPago(), editCommand.getReferenciaPago());
	}

	public EPagoDTO toDto(EPago model)
	{
		return new EPagoDTO(model.getPecPagoId(), model.getPacEstadoCuentaId(), model.getFechaPago(), model.getMonto(),
				model.getMetodoPago(), model.getReferenciaPago());
	}
}