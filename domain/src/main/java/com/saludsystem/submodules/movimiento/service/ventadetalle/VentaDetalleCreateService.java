package com.saludsystem.submodules.movimiento.service.ventadetalle;

import com.saludsystem.submodules.movimiento.model.VentaDetalle;
import com.saludsystem.submodules.movimiento.port.repository.VentaDetalleRepository;

public class VentaDetalleCreateService {

    private final VentaDetalleRepository ventaDetalleRepository;

    public VentaDetalleCreateService(VentaDetalleRepository ventaDetalleRepository) {
        this.ventaDetalleRepository = ventaDetalleRepository;
    }

    public VentaDetalle execute(VentaDetalle ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }

}
