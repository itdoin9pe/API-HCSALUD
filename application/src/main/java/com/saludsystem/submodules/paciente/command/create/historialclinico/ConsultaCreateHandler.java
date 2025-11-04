package com.saludsystem.submodules.paciente.command.create.historialclinico;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ConsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.ConsultaCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.consulta.ConsultaCreateService;

@Component
public class ConsultaCreateHandler
{
	private final ConsultaCreateService consultaCreateService;
	private final ConsultaMapper consultaMapper;

	public ConsultaCreateHandler(ConsultaCreateService consultaCreateService, ConsultaMapper consultaMapper)
	{
		this.consultaCreateService = consultaCreateService;
		this.consultaMapper = consultaMapper;
	}

	public void execute(ConsultaCreateCommand createCommand)
	{
		var consultaSaved = consultaMapper.fromCreateDto(createCommand);
		consultaCreateService.execute(consultaSaved);
	}
}