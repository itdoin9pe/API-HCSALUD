package com.saludsystem.submodules.configuracion.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.ClinicaMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.ClinicaEditCommand;
import com.saludsystem.submodules.configuracion.service.clinica.ClinicaEditService;

@Component
public class ClinicaEditHandler
{
	private final ClinicaEditService clinicaEditService;
	private final ClinicaMapper clinicaMapper;

	public ClinicaEditHandler(ClinicaEditService clinicaEditService, ClinicaMapper clinicaMapper)
	{
		this.clinicaEditService = clinicaEditService;
		this.clinicaMapper = clinicaMapper;
	}

	public void execute(UUID uuid, ClinicaEditCommand editCommand)
	{
		var clinicaUpdated = clinicaMapper.fromUpdateDto(uuid, editCommand);
		clinicaEditService.execute(uuid, clinicaUpdated);
	}
}