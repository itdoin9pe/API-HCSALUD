package com.saludsystem.submodules.paciente.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.PConsentimientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.PConsentimientoCreateCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.pconsentimiento.PConsentimientoCreateService;

@Component
public class PConsentimientoCreateHandler
{
	private final PConsentimientoCreateService pConsentimientoCreateService;
	private final PConsentimientoMapper pConsentimientoMapper;

	public PConsentimientoCreateHandler(
		PConsentimientoCreateService pConsentimientoCreateService,
		PConsentimientoMapper pConsentimientoMapper)
	{
		this.pConsentimientoCreateService = pConsentimientoCreateService;
		this.pConsentimientoMapper = pConsentimientoMapper;
	}

	public void execute(PConsentimientoCreateCommand createCommand)
	{
		var pacienteConsentSaved = pConsentimientoMapper.fromCreateDto(createCommand);
		pConsentimientoCreateService.execute(pacienteConsentSaved);
	}
}