package com.saludsystem.submodules.movimiento.service.ventadetalle;

import com.saludsystem.submodules.movimiento.port.dao.VentaDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.VentaDetalleRepository;

import java.util.UUID;

public class VentaDetalleDeleteService {

    private final VentaDetalleRepository ventaDetalleRepository;
    private final VentaDetalleDao ventaDetalleDao;

    public VentaDetalleDeleteService(VentaDetalleRepository ventaDetalleRepository, VentaDetalleDao ventaDetalleDao) {
        this.ventaDetalleRepository = ventaDetalleRepository;
        this.ventaDetalleDao = ventaDetalleDao;
    }

    public void execute(UUID uuid) {

        var ventaDetalle = ventaDetalleDao.getById(uuid);

        if (ventaDetalle.getCantidad() != null && ventaDetalle.getCantidad() == 0) {

            throw new IllegalArgumentException("No se puede eliminar una venta sin cantidad registrada");

        }

        ventaDetalleRepository.delete(uuid);

    }

}
