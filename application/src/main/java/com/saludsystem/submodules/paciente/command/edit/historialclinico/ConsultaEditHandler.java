package com.saludsystem.submodules.paciente.command.edit.historialclinico;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ConsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.ConsultaEditCommand;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.consulta.ConsultaEditService;

@Component
public class ConsultaEditHandler
{
	private final ConsultaEditService consultaEditService;
	private final ConsultaMapper consultaMapper;

	public ConsultaEditHandler(ConsultaEditService consultaEditService, ConsultaMapper consultaMapper)
	{
		this.consultaEditService = consultaEditService;
		this.consultaMapper = consultaMapper;
	}

	public void execute(UUID uuid, ConsultaEditCommand editCommand)
	{
		var consultaUpdated = consultaMapper.fromUpdateDto(uuid, editCommand);
		consultaEditService.execute(uuid, consultaUpdated);
	}
}