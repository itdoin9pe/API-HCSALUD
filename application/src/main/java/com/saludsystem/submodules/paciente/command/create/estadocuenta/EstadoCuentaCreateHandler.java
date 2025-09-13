package com.saludsystem.submodules.paciente.command.create.estadocuenta;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EstadoCuentaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.EstadoCuentaCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.EstadoCuentaCreateService;

@Component
public class EstadoCuentaCreateHandler
{
	private final EstadoCuentaCreateService estadoCuentaCreateService;
	private final EstadoCuentaMapper estadoCuentaMapper;

	public EstadoCuentaCreateHandler(
		EstadoCuentaCreateService estadoCuentaCreateService,
		EstadoCuentaMapper estadoCuentaMapper)
	{
		this.estadoCuentaCreateService = estadoCuentaCreateService;
		this.estadoCuentaMapper = estadoCuentaMapper;
	}

	public void execute(EstadoCuentaCreateCommand createCommand)
	{
		var estadoCuentaSaved = estadoCuentaMapper.fromCreateDto(createCommand);
		estadoCuentaCreateService.execute(estadoCuentaSaved);
	}
}