package com.saludsystem.submodules.movimiento.service.compradetalle;

import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.model.constant.CompraDetalleConstant;
import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;

import java.util.UUID;

public class CompraDetalleEditService {

    private final CompraDetalleDao compraDetalleDao;
    private final CompraDetalleRepository compraDetalleRepository;

    public CompraDetalleEditService(CompraDetalleDao compraDetalleDao, CompraDetalleRepository compraDetalleRepository) {
        this.compraDetalleDao = compraDetalleDao;
        this.compraDetalleRepository = compraDetalleRepository;
    }

    public CompraDetalle execute(UUID uuid, CompraDetalle compraDetalle) {
        var currentCompraDetalle = compraDetalleDao.getById(uuid);
        if (currentCompraDetalle == null) {
            throw new IllegalArgumentException(CompraDetalleConstant.INVALID_ID);
        }
        if (compraDetalle.getCantidad() != null && compraDetalle.getCantidad().equals(0)) {
            throw new IllegalStateException("La cantidad del detalle de la compra esta vacia");
        }
        return compraDetalleRepository.update(uuid, compraDetalle);
    }

}
