package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoTarjetaListHandler {

    private final TipoTarjetaDao tipoTarjetaDao;
    private final TipoTarjetaMapper tipoTarjetaMapper;

    public TipoTarjetaListHandler(TipoTarjetaDao tipoTarjetaDao, TipoTarjetaMapper tipoTarjetaMapper) {
        this.tipoTarjetaDao = tipoTarjetaDao;
        this.tipoTarjetaMapper = tipoTarjetaMapper;
    }

    public List<TipoTarjetaDTO> execute() {

        List<TipoTarjeta> tipoTarjetaList = tipoTarjetaDao.getList();

        return tipoTarjetaList
                .stream()
                .map(tipoTarjetaMapper::toDto)
                .toList();

    }

}
