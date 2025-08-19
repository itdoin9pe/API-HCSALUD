package com.saludsystem.submodules.movimiento.service.ventadetalle;

import com.saludsystem.submodules.movimiento.model.VentaDetalle;
import com.saludsystem.submodules.movimiento.port.dao.VentaDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.VentaDetalleRepository;

public class VentaDetalleCreateService {

    private final VentaDetalleRepository ventaDetalleRepository;
    private final VentaDetalleDao ventaDetalleDao;

    public VentaDetalleCreateService(VentaDetalleRepository ventaDetalleRepository, VentaDetalleDao ventaDetalleDao) {
        this.ventaDetalleRepository = ventaDetalleRepository;
        this.ventaDetalleDao = ventaDetalleDao;
    }

    public VentaDetalle execute(VentaDetalle ventaDetalle) {

        return ventaDetalleRepository.save(ventaDetalle);

    }

}
