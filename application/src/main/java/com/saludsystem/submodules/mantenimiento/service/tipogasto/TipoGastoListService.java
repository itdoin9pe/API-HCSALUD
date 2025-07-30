package com.saludsystem.submodules.mantenimiento.service.tipogasto;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;

import java.util.List;

public class TipoGastoListService {

    private final TipoGastoDao tipoGastoDao;

    public TipoGastoListService(TipoGastoDao tipoGastoDao) {
        this.tipoGastoDao = tipoGastoDao;
    }

    public List<TipoGastoDTO> execute() {
        return tipoGastoDao.getList()
                .stream()
                .map(TipoGastoMapper::toDto)
                .toList();
    }
}
