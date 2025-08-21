package com.saludsystem.submodules.movimiento.command.delete;

import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraDetalleDeleteHandler {

    private final CompraDetalleRepository compraDetalleRepository;
    private final CompraDetalleDao compraDetalleDao;

    public CompraDetalleDeleteHandler(CompraDetalleRepository compraDetalleRepository, CompraDetalleDao compraDetalleDao) {
        this.compraDetalleRepository = compraDetalleRepository;
        this.compraDetalleDao = compraDetalleDao;
    }

    public void execute(UUID uuid) {
        compraDetalleRepository.delete(uuid);
    }

}
