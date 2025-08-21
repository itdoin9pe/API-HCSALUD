package com.saludsystem.submodules.movimiento.query.getById;

import com.saludsystem.submodules.movimiento.mapper.CompraDetalleMapper;
import com.saludsystem.submodules.movimiento.model.constant.CompraDetalleConstant;
import com.saludsystem.submodules.movimiento.model.dtos.CompraDetalleDTO;
import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraDetalleByIdHandler {

    private final CompraDetalleDao compraDetalleDao;
    private final CompraDetalleMapper compraDetalleMapper;

    public CompraDetalleByIdHandler(CompraDetalleDao compraDetalleDao, CompraDetalleMapper compraDetalleMapper) {
        this.compraDetalleDao = compraDetalleDao;
        this.compraDetalleMapper = compraDetalleMapper;
    }

    public CompraDetalleDTO execute(UUID uuid) {

        var compraDetalle = compraDetalleDao.getById(uuid);

        if (compraDetalle == null) {
            throw new IllegalArgumentException(CompraDetalleConstant.INVALID_ID);
        }

        return compraDetalleMapper.toDto(compraDetalle);

    }

}
