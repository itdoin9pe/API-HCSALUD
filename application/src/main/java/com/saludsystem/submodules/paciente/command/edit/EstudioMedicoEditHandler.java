package com.saludsystem.submodules.paciente.command.edit;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.EstudioMedicoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.EstudioMedicoEditCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico.EstudioMedicoEditService;

@Component
public class EstudioMedicoEditHandler
{
	private final EstudioMedicoEditService estudioMedicoEditService;
	private final EstudioMedicoMapper estudioMedicoMapper;

	public EstudioMedicoEditHandler(
		EstudioMedicoEditService estudioMedicoEditService,
		EstudioMedicoMapper estudioMedicoMapper)
	{
		this.estudioMedicoEditService = estudioMedicoEditService;
		this.estudioMedicoMapper = estudioMedicoMapper;
	}

	public void execute(Long id, EstudioMedicoEditCommand editCommand)
	{
		var estudioMedicoUpdated = estudioMedicoMapper.fromUpdateDto(id, editCommand);
		estudioMedicoEditService.execute(id, estudioMedicoUpdated);
	}
}