package com.saludsystem.submodules.movimiento.query.getById;

import com.saludsystem.submodules.movimiento.mapper.VentaMapper;
import com.saludsystem.submodules.movimiento.model.constant.VentaConstant;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDTO;
import com.saludsystem.submodules.movimiento.port.dao.VentaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VentaByIdHandler {

    private final VentaDao ventaDao;
    private final VentaMapper ventaMapper;

    public VentaByIdHandler(VentaDao ventaDao, VentaMapper ventaMapper) {
        this.ventaDao = ventaDao;
        this.ventaMapper = ventaMapper;
    }

    public VentaDTO execute(UUID uuid) {

        var venta = ventaDao.getById(uuid);

        if (venta == null) {

            throw new IllegalArgumentException(VentaConstant.INVALID_ID);

        }

        return ventaMapper.toDto(venta);

    }

}
