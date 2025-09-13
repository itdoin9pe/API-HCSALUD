package com.saludsystem.submodules.movimiento.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.InventarioMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.InventarioEditCommand;
import com.saludsystem.submodules.movimiento.service.inventario.InventarioEditService;

@Component
public class InventarioEditHandler
{
	private final InventarioEditService inventarioEditService;
	private final InventarioMapper inventarioMapper;

	/**
	 * @param inventarioEditService
	 * @param inventarioMapper
	 */
	public InventarioEditHandler(InventarioEditService inventarioEditService, InventarioMapper inventarioMapper)
	{
		this.inventarioEditService = inventarioEditService;
		this.inventarioMapper = inventarioMapper;
	}

	public void execute(UUID uuid, InventarioEditCommand editCommand)
	{
		var inventarioUpdated = inventarioMapper.fromUpdateDto(uuid, editCommand);
		inventarioEditService.execute(uuid, inventarioUpdated);
	}
}