package com.saludsystem.submodules.paciente.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.DiagnosticoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.DiagnosticoEditCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.diagnostico.DiagnosticoEditService;

@Component
public class DiagnosticoEditHandler
{
	private final DiagnosticoEditService diagnosticoEditService;
	private final DiagnosticoMapper diagnosticoMapper;

	public DiagnosticoEditHandler(DiagnosticoEditService diagnosticoEditService, DiagnosticoMapper diagnosticoMapper)
	{
		this.diagnosticoEditService = diagnosticoEditService;
		this.diagnosticoMapper = diagnosticoMapper;
	}

	public void execute(UUID uuid, DiagnosticoEditCommand editCommand)
	{
		var diagosticoUpdated = diagnosticoMapper.fromUpdateDto(uuid, editCommand);
		diagnosticoEditService.execute(uuid, diagosticoUpdated);
	}
}