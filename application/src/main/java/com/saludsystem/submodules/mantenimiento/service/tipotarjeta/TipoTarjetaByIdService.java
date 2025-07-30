package com.saludsystem.submodules.mantenimiento.service.tipotarjeta;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;

import java.util.UUID;

public class TipoTarjetaByIdService {

    private final TipoTarjetaDao tipoTarjetaDao;

    public TipoTarjetaByIdService(TipoTarjetaDao tipoTarjetaDao) {
        this.tipoTarjetaDao = tipoTarjetaDao;
    }

    public TipoTarjetaDTO execute(UUID uuid) {
        return TipoTarjetaMapper.toDto(tipoTarjetaDao.getById(uuid));
    }
}
