package com.saludsystem.submodules.movimiento.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.InventarioMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.InventarioCreateCommand;
import com.saludsystem.submodules.movimiento.service.inventario.InventarioCreateService;

@Component
public class InventarioCreateHandler
{
	private final InventarioCreateService inventarioCreateService;
	private final InventarioMapper inventarioMapper;

	public InventarioCreateHandler(InventarioCreateService inventarioCreateService, InventarioMapper inventarioMapper)
	{
		this.inventarioCreateService = inventarioCreateService;
		this.inventarioMapper = inventarioMapper;
	}

	public void execute(InventarioCreateCommand createCommand)
	{
		var inventarioCreated = inventarioMapper.fromCreateDto(createCommand);
		inventarioCreateService.execute(inventarioCreated);
	}
}