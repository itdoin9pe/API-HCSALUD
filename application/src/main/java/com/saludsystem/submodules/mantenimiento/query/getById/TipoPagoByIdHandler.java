package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.model.constant.TipoPagoConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoPagoByIdHandler {

    private final TipoPagoDao tipoPagoDao;
    private final TipoPagoMapper tipoPagoMapper;

    public TipoPagoByIdHandler(TipoPagoDao tipoPagoDao, TipoPagoMapper tipoPagoMapper) {
        this.tipoPagoDao = tipoPagoDao;
        this.tipoPagoMapper = tipoPagoMapper;
    }

    public TipoPagoDTO execute(UUID uuid) {

        var tipoPago = tipoPagoDao.getById(uuid);

        if (tipoPago == null) {

            throw new IllegalArgumentException(TipoPagoConstant.INVALID_ID);

        }

        return tipoPagoMapper.toDto(tipoPago);

    }

}
