package com.saludsystem.submodules.movimiento.command.edit;

import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.model.constant.CompraDetalleConstant;
import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraDetalleEditHandler {

    private final CompraDetalleDao compraDetalleDao;
    private final CompraDetalleRepository compraDetalleRepository;

    public CompraDetalleEditHandler(CompraDetalleDao compraDetalleDao, CompraDetalleRepository compraDetalleRepository) {
        this.compraDetalleDao = compraDetalleDao;
        this.compraDetalleRepository = compraDetalleRepository;
    }

    public CompraDetalle execute(UUID uuid, CompraDetalle compraDetalle) {

        var currentCompraDetalle = compraDetalleDao.getById(uuid);

        if (currentCompraDetalle == null) {
            throw new IllegalArgumentException(CompraDetalleConstant.INVALID_ID);
        }

        if (currentCompraDetalle.getCantidad() != null && currentCompraDetalle.getCantidad() == 0) {
            throw new IllegalStateException("La cantidad no es valida");
        }

        return compraDetalleRepository.update(uuid, compraDetalle);

    }

}
