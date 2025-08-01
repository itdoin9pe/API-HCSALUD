package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.model.constant.TipoGastoConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoGastoByIdHandler {

    private final TipoGastoDao tipoGastoDao;
    private final TipoGastoMapper tipoGastoMapper;

    public TipoGastoByIdHandler(TipoGastoDao tipoGastoDao, TipoGastoMapper tipoGastoMapper) {
        this.tipoGastoDao = tipoGastoDao;
        this.tipoGastoMapper = tipoGastoMapper;
    }

    public TipoGastoDTO execute(UUID uuid) {

        var tipoGasto = tipoGastoDao.getById(uuid);

        if (tipoGasto == null) {

            throw new IllegalArgumentException(TipoGastoConstant.INVALID_ID);

        }

        return tipoGastoMapper.toDto(tipoGasto);

    }

}
