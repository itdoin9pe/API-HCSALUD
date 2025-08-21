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

        var compraDetalle = compraDetalleDao.getById(uuid);

        if (compraDetalle.getCantidad() != null && compraDetalle.getCantidad() == 0) {
            throw new IllegalStateException("No se puede eliminar un detalle de la compra sin cantidad ingresada");
        }

        compraDetalleRepository.delete(uuid);

    }

}
