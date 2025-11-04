package com.saludsystem.submodules.mantenimiento.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.model.dtos.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TarifarioCreateCommand;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioCreateService;
import com.saludsystem.submodules.mantenimiento.validators.TarifarioValidator;

@Component
public class TarifarioCreateHandler
{
	private final TarifarioCreateService tarifarioCreateService;
	private final TarifarioMapper tarifarioMapper;
	private final TarifarioValidator tarifarioValidator;

	public TarifarioCreateHandler(
		TarifarioCreateService tarifarioCreateService,
		TarifarioMapper tarifarioMapper,
		TarifarioValidator tarifarioValidator)
	{
		this.tarifarioCreateService = tarifarioCreateService;
		this.tarifarioMapper = tarifarioMapper;
		this.tarifarioValidator = tarifarioValidator;
	}

	public TarifarioDTO execute(TarifarioCreateCommand createCommand)
	{
		tarifarioValidator.validateForCreation(createCommand);
		Tarifario tarifario = tarifarioMapper.fromCreateDto(createCommand);
		Tarifario created = tarifarioCreateService.execute(tarifario);
		return tarifarioMapper.toDto(created);
	}
}