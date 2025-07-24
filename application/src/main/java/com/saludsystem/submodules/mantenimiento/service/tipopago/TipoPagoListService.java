package com.saludsystem.submodules.mantenimiento.service.tipopago;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;

import java.util.List;

public class TipoPagoListService {

    private final TipoPagoDao tipoPagoDao;

    public TipoPagoListService(TipoPagoDao tipoPagoDao) {
        this.tipoPagoDao = tipoPagoDao;
    }

    public List<TipoPagoDTO> execute() {
        return tipoPagoDao.getList()
                .stream()
                .map(TipoPagoMapper::toDto)
                .toList();
    }
}
