package com.saludsystem.submodules.movimiento.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.service.ventadetalle.VentaDetalleDeleteService;

@Component
public class VentaDetalleDeleteHandler {

	private final VentaDetalleDeleteService ventaDetalleDeleteService;

	/**
	 * @param ventaDetalleDeleteService
	 */
	public VentaDetalleDeleteHandler(VentaDetalleDeleteService ventaDetalleDeleteService) {
		this.ventaDetalleDeleteService = ventaDetalleDeleteService;
	}
	
	public void execute(UUID uuid) {
		ventaDetalleDeleteService.execute(uuid);
	}

}
