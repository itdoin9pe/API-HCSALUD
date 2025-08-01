package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoPagoListHandler {

    private final TipoPagoDao tipoPagoDao;
    private final TipoPagoMapper tipoPagoMapper;

    public TipoPagoListHandler(TipoPagoDao tipoPagoDao, TipoPagoMapper tipoPagoMapper) {
        this.tipoPagoDao = tipoPagoDao;
        this.tipoPagoMapper = tipoPagoMapper;
    }

    public List<TipoPagoDTO> execute() {

        List<TipoPago> tipoPagoList = tipoPagoDao.getList();

        return tipoPagoList.stream()
                .map(tipoPagoMapper::toDto)
                .toList();

    }

}
