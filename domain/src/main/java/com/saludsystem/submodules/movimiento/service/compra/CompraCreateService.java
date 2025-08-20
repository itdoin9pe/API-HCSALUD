package com.saludsystem.submodules.movimiento.service.compra;

import com.saludsystem.submodules.movimiento.model.Compra;
import com.saludsystem.submodules.movimiento.port.repository.CompraRepository;

public class CompraCreateService {

    private final CompraRepository compraRepository;

    public CompraCreateService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Compra execute(Compra compra) {
        return compraRepository.save(compra);
    }

}
