package com.saludsystem.submodules.mantenimiento.service.tipopago;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;

import java.util.UUID;

public class TipoPagoByIdService {

    private final TipoPagoDao tipoPagoDao;

    public TipoPagoByIdService(TipoPagoDao tipoPagoDao) {
        this.tipoPagoDao = tipoPagoDao;
    }

    public TipoPagoDTO execute(UUID uuid) {
        return TipoPagoMapper.toDto(tipoPagoDao.getById(uuid));
    }
}
