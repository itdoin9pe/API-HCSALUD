package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoGasto;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoGastoListHandler {

    private final TipoGastoDao tipoGastoDao;
    private final TipoGastoMapper tipoGastoMapper;

    public TipoGastoListHandler(TipoGastoDao tipoGastoDao, TipoGastoMapper tipoGastoMapper) {
        this.tipoGastoDao = tipoGastoDao;
        this.tipoGastoMapper = tipoGastoMapper;
    }

    public List<TipoGastoDTO> execute() {

        List<TipoGasto> tipoGastoList = tipoGastoDao.getList();

        return tipoGastoList
                .stream()
                .map(tipoGastoMapper::toDto)
                .toList();

    }

}
