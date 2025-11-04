package com.saludsystem.submodules.paciente.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.EstudioResultadoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.EstudioResultadoCreateCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudioresultado.EstudioResultadoCreateService;

@Component
public class EstudioResultadoCreateHandler
{
	private final EstudioResultadoCreateService estudioResultadoCreateService;
	private final EstudioResultadoMapper estudioResultadoMapper;

	public EstudioResultadoCreateHandler(
		EstudioResultadoCreateService estudioResultadoCreateService,
		EstudioResultadoMapper estudioResultadoMapper)
	{
		this.estudioResultadoCreateService = estudioResultadoCreateService;
		this.estudioResultadoMapper = estudioResultadoMapper;
	}

	public void execute(EstudioResultadoCreateCommand createCommand)
	{
		var estudioResultadoSaved = estudioResultadoMapper.fromCreateDto(createCommand);
		estudioResultadoCreateService.execute(estudioResultadoSaved);
	}
}