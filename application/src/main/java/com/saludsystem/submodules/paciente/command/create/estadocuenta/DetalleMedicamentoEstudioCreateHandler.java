package com.saludsystem.submodules.paciente.command.create.estadocuenta;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.DetalleMedicamentoEstudioMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.DetalleMedicamentoEstudioCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio.DetalleMedicamentoEstudioCreateService;

@Component
public class DetalleMedicamentoEstudioCreateHandler
{
	private final DetalleMedicamentoEstudioCreateService detalleMedicamentoEstudioCreateService;
	private final DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper;

	public DetalleMedicamentoEstudioCreateHandler(
		DetalleMedicamentoEstudioCreateService detalleMedicamentoEstudioCreateService,
		DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper)
	{
		this.detalleMedicamentoEstudioCreateService = detalleMedicamentoEstudioCreateService;
		this.detalleMedicamentoEstudioMapper = detalleMedicamentoEstudioMapper;
	}

	public void execute(DetalleMedicamentoEstudioCreateCommand createCommand)
	{
		var detMedicEstudioSaved = detalleMedicamentoEstudioMapper.fromCreateDto(createCommand);
		detalleMedicamentoEstudioCreateService.execute(detMedicEstudioSaved);
	}
}