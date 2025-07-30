package com.saludsystem.submodules.mantenimiento.service.tipotarjeta;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;

import java.util.List;

public class TipoTarjetaListService {

    private final TipoTarjetaDao tipoTarjetaDao;

    public TipoTarjetaListService(TipoTarjetaDao tipoTarjetaDao) {
        this.tipoTarjetaDao = tipoTarjetaDao;
    }

    public List<TipoTarjetaDTO> execute() {
        return tipoTarjetaDao.getList()
                .stream()
                .map(TipoTarjetaMapper::toDto)
                .toList();
    }
}
