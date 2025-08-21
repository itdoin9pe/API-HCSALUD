package com.saludsystem.submodules.movimiento.command.create;

import com.saludsystem.submodules.movimiento.mapper.CompraDetalleMapper;
import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.model.dtos.command.CompraDetalleCreateCommand;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;
import org.springframework.stereotype.Component;

@Component
public class CompraDetalleCreateHandler {

    private final CompraDetalleRepository compraDetalleRepository;
    private final CompraDetalleMapper compraDetalleMapper;

    public CompraDetalleCreateHandler(CompraDetalleRepository compraDetalleRepository, CompraDetalleMapper compraDetalleMapper) {
        this.compraDetalleRepository = compraDetalleRepository;
        this.compraDetalleMapper = compraDetalleMapper;
    }

    public void execute(CompraDetalleCreateCommand createCommand) {

        var compraDetalleSaved = compraDetalleMapper.fromCreateDto(createCommand);

        compraDetalleRepository.save(compraDetalleSaved);

    }

}
