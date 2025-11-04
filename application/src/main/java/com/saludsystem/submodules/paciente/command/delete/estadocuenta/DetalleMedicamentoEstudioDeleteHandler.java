package com.saludsystem.submodules.paciente.command.delete.estadocuenta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio.DetalleMedicamentoEstudioDeleteService;

@Component
public class DetalleMedicamentoEstudioDeleteHandler
{
	private final DetalleMedicamentoEstudioDeleteService detalleMedicamentoEstudioDeleteService;

	public DetalleMedicamentoEstudioDeleteHandler(
		DetalleMedicamentoEstudioDeleteService detalleMedicamentoEstudioDeleteService)
	{
		this.detalleMedicamentoEstudioDeleteService = detalleMedicamentoEstudioDeleteService;
	}

	public void execute(UUID uuid)
	{
		detalleMedicamentoEstudioDeleteService.execute(uuid);
	}
}