package com.saludsystem.submodules.movimiento.service.compradetalle;

import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;

public class CompraDetalleCreateService {

    private final CompraDetalleRepository compraDetalleRepository;

    public CompraDetalleCreateService(CompraDetalleRepository compraDetalleRepository) {
        this.compraDetalleRepository = compraDetalleRepository;
    }

    public CompraDetalle execute(CompraDetalle compraDetalle) {

        return compraDetalleRepository.save(compraDetalle);

    }

}
