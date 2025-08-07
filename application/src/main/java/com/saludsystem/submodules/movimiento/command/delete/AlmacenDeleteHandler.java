package com.saludsystem.submodules.movimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.service.almacen.AlmacenDeleteService;

@Component
public class AlmacenDeleteHandler {

	private final AlmacenDeleteService almacenDeleteService;

	/**
	 * @param almacenDeleteService
	 */
	public AlmacenDeleteHandler(AlmacenDeleteService almacenDeleteService) {
		this.almacenDeleteService = almacenDeleteService;
	}
	
	public void execute(UUID uuid) {
		
		almacenDeleteService.execute(uuid);
		
	}

}
