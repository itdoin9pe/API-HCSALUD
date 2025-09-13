package com.saludsystem.submodules.paciente.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.PConsentimientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.PConsentimientoEditCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.pconsentimiento.PConsentimientoEditService;

@Component
public class PConsentimientoEditHandler
{
	private final PConsentimientoEditService pConsentimientoEditService;
	private final PConsentimientoMapper pConsentimientoMapper;

	public PConsentimientoEditHandler(
		PConsentimientoEditService pConsentimientoEditService,
		PConsentimientoMapper pConsentimientoMapper)
	{
		this.pConsentimientoEditService = pConsentimientoEditService;
		this.pConsentimientoMapper = pConsentimientoMapper;
	}

	public void execute(UUID uuid, PConsentimientoEditCommand editCommand)
	{
		var pConsentimientoUpdated = pConsentimientoMapper.fromUpdateDto(uuid, editCommand);
		pConsentimientoEditService.execute(uuid, pConsentimientoUpdated);
	}
}