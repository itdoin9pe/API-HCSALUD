package com.saludsystem.submodules.movimiento.service.ventadetalle;

import com.saludsystem.submodules.movimiento.model.VentaDetalle;
import com.saludsystem.submodules.movimiento.model.constant.VentaDetalleConstant;
import com.saludsystem.submodules.movimiento.port.dao.VentaDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.VentaDetalleRepository;

import java.util.UUID;

public class VentaDetalleEditService {

    private final VentaDetalleDao ventaDetalleDao;
    private final VentaDetalleRepository ventaDetalleRepository;

    public VentaDetalleEditService(VentaDetalleDao ventaDetalleDao, VentaDetalleRepository ventaDetalleRepository) {
        this.ventaDetalleDao = ventaDetalleDao;
        this.ventaDetalleRepository = ventaDetalleRepository;
    }

    public VentaDetalle execute(UUID uuid, VentaDetalle ventaDetalle) {
        var currentVentaDetalle = ventaDetalleDao.getById(uuid);
        if (currentVentaDetalle == null) {
            throw new IllegalArgumentException(VentaDetalleConstant.INVALID_ID);
        }
        if (currentVentaDetalle.getCantidad() != null && currentVentaDetalle.getCantidad() == 0) {
            throw new IllegalArgumentException("El detalle de venta no tiene cantidad validad");
        }
        return ventaDetalleRepository.update(uuid, ventaDetalle);
    }

}
