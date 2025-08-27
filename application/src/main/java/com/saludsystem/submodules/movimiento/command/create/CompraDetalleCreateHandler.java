package com.saludsystem.submodules.movimiento.command.create;

import com.saludsystem.submodules.movimiento.mapper.CompraDetalleMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.CompraDetalleCreateCommand;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;
import com.saludsystem.submodules.movimiento.service.compradetalle.CompraDetalleCreateService;

import org.springframework.stereotype.Component;

@Component
public class CompraDetalleCreateHandler {

    private final CompraDetalleCreateService compraDetalleCreateService;
    private final CompraDetalleMapper compraDetalleMapper;

    /**
	 * @param compraDetalleCreateService
	 * @param compraDetalleMapper
	 */
	public CompraDetalleCreateHandler(CompraDetalleCreateService compraDetalleCreateService,
			CompraDetalleMapper compraDetalleMapper) {
		this.compraDetalleCreateService = compraDetalleCreateService;
		this.compraDetalleMapper = compraDetalleMapper;
	}


	public void execute(CompraDetalleCreateCommand createCommand) {

        var compraDetalleSaved = compraDetalleMapper.fromCreateDto(createCommand);

        compraDetalleCreateService.execute(compraDetalleSaved);

    }

}
