package com.saludsystem.submodules.movimiento.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.AlmacenMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.AlmacenCreateCommand;
import com.saludsystem.submodules.movimiento.service.almacen.AlmacenCreateService;

@Component
public class AlmacenCreateHandler
{
	private final AlmacenCreateService almacenCreateService;
	private final AlmacenMapper almacenMapper;

	/**
	 * @param almacenCreateService
	 * @param almacenMapper
	 */
	public AlmacenCreateHandler(AlmacenCreateService almacenCreateService, AlmacenMapper almacenMapper)
	{
		this.almacenCreateService = almacenCreateService;
		this.almacenMapper = almacenMapper;
	}

	public void execute(AlmacenCreateCommand createCommand)
	{
		var almacenSaved = almacenMapper.fromCreateDto(createCommand);
		almacenCreateService.execute(almacenSaved);
	}
}
