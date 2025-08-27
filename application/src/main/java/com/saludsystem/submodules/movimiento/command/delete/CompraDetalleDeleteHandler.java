package com.saludsystem.submodules.movimiento.command.delete;

import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;
import com.saludsystem.submodules.movimiento.service.compradetalle.CompraDetalleDeleteService;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraDetalleDeleteHandler {

    private final CompraDetalleDeleteService compraDetalleDeleteService;

    /**
	 * @param compraDetalleDeleteService
	 */
	public CompraDetalleDeleteHandler(CompraDetalleDeleteService compraDetalleDeleteService) {
		this.compraDetalleDeleteService = compraDetalleDeleteService;
	}

	public void execute(UUID uuid) {
		compraDetalleDeleteService.execute(uuid);
    }

}
