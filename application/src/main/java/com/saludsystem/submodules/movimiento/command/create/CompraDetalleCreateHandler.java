package com.saludsystem.submodules.movimiento.command.create;

import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;
import org.springframework.stereotype.Component;

@Component
public class CompraDetalleCreateHandler {

    private final CompraDetalleRepository compraDetalleRepository;

    public CompraDetalleCreateHandler(CompraDetalleRepository compraDetalleRepository) {
        this.compraDetalleRepository = compraDetalleRepository;
    }

    public CompraDetalle execute(CompraDetalle compraDetalle) {
        return compraDetalleRepository.save(compraDetalle);
    }

}
