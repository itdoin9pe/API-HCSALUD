package com.saludsystem.submodules.movimiento.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.AlmacenMapper;
import com.saludsystem.submodules.movimiento.model.dtos.edit.AlmacenEditCommand;
import com.saludsystem.submodules.movimiento.service.almacen.AlmacenEditService;

@Component
public class AlmacenEditHandler {
	
	private final AlmacenEditService almacenEditService;
	private final AlmacenMapper almacenMapper;
	
	/**
	 * @param almacenEditService
	 * @param almacenMapper
	 */
	public AlmacenEditHandler(AlmacenEditService almacenEditService, AlmacenMapper almacenMapper) {
		this.almacenEditService = almacenEditService;
		this.almacenMapper = almacenMapper;
	}

	public void execute(UUID uuid, AlmacenEditCommand editCommand) {
		
		var almacenUpdated = almacenMapper.fromUpdateDto(uuid, editCommand);
		
		almacenEditService.execute(uuid, almacenUpdated);
		
	}
	
}
