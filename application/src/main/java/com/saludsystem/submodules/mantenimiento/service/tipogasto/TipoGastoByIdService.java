package com.saludsystem.submodules.mantenimiento.service.tipogasto;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;

import java.util.UUID;

public class TipoGastoByIdService {

    private final TipoGastoDao tipoGastoDao;

    public TipoGastoByIdService(TipoGastoDao tipoGastoDao) {
        this.tipoGastoDao = tipoGastoDao;
    }

    public TipoGastoDTO execute(UUID uuid) {
        return TipoGastoMapper.toDto(tipoGastoDao.getById(uuid));
    }

}
