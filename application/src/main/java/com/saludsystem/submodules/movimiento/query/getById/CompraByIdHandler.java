package com.saludsystem.submodules.movimiento.query.getById;

import com.saludsystem.submodules.movimiento.mapper.CompraMapper;
import com.saludsystem.submodules.movimiento.model.constant.CompraConstant;
import com.saludsystem.submodules.movimiento.model.dtos.CompraDTO;
import com.saludsystem.submodules.movimiento.port.dao.CompraDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompraByIdHandler {

    private final CompraDao compraDao;
    private final CompraMapper compraMapper;

    public CompraByIdHandler(CompraDao compraDao, CompraMapper compraMapper) {
        this.compraDao = compraDao;
        this.compraMapper = compraMapper;
    }

    public CompraDTO execute(UUID uuid) {

        var compra = compraDao.getById(uuid);

        if (compra == null) {

            throw new IllegalArgumentException(CompraConstant.INVALID_ID);

        }

        return compraMapper.toDto(compra);

    }

}
