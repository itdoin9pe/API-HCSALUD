package com.saludsystem.submodules.catalogo.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.AlergiaCreateCommand;
import com.saludsystem.submodules.catalogo.service.alergia.AlergiaCreateService;

@Component
public class AlergiaCreateHandler
{
	private final AlergiaCreateService alergiaCreateService;
	private final AlergiaMapper alergiaMapper;

	public AlergiaCreateHandler(AlergiaCreateService alergiaCreateService, AlergiaMapper alergiaMapper)
	{
		this.alergiaCreateService = alergiaCreateService;
		this.alergiaMapper = alergiaMapper;
	}

	public void execute(AlergiaCreateCommand createCommand)
	{

		var marca = alergiaMapper.fromCreateDto(createCommand);

		alergiaCreateService.execute(marca);

	}
}