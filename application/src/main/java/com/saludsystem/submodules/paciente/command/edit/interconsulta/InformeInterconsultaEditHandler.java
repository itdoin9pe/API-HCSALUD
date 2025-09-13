package com.saludsystem.submodules.paciente.command.edit.interconsulta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InformeInterconsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.interconsulta.InformeInterconsultaEditCommand;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.informeinterconsulta.InformeInterEditService;

@Component
public class InformeInterconsultaEditHandler
{
	private final InformeInterEditService informeInterEditService;
	private final InformeInterconsultaMapper informeInterconsultaMapper;

	public InformeInterconsultaEditHandler(
		InformeInterEditService informeInterEditService,
		InformeInterconsultaMapper informeInterconsultaMapper)
	{
		this.informeInterEditService = informeInterEditService;
		this.informeInterconsultaMapper = informeInterconsultaMapper;
	}

	public void execute(UUID uuid, InformeInterconsultaEditCommand editCommand)
	{
		var informeInterUpdated = informeInterconsultaMapper.fromUpdateDto(uuid, editCommand);
		informeInterEditService.execute(uuid, informeInterUpdated);
	}
}