package com.saludsystem.submodules.configuracion.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.ClinicaMapper;
import com.saludsystem.submodules.configuracion.model.dtos.command.ClinicaCreateCommand;
import com.saludsystem.submodules.configuracion.service.clinica.ClinicaCreateService;

@Component
public class ClinicaCreateHandler
{
	private final ClinicaCreateService clinicaCreateService;
	private final ClinicaMapper clinicaMapper;

	public ClinicaCreateHandler(ClinicaCreateService clinicaCreateService, ClinicaMapper clinicaMapper)
	{
		this.clinicaCreateService = clinicaCreateService;
		this.clinicaMapper = clinicaMapper;
	}

	public void execute(ClinicaCreateCommand createCommand)
	{
		var cliSaved = clinicaMapper.fromCreateDto(createCommand);
		clinicaCreateService.execute(cliSaved);
	}
}