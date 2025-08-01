package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.model.constant.TipoTarjetaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoTarjetaByIdHandler {

    private final TipoTarjetaDao tipoTarjetaDao;
    private final TipoTarjetaMapper tipoTarjetaMapper;

    public TipoTarjetaByIdHandler(TipoTarjetaDao tipoTarjetaDao, TipoTarjetaMapper tipoTarjetaMapper) {
        this.tipoTarjetaDao = tipoTarjetaDao;
        this.tipoTarjetaMapper = tipoTarjetaMapper;
    }

    public TipoTarjetaDTO execute(UUID uuid) {

        var tipoTarjeta = tipoTarjetaDao.getById(uuid);

        if (tipoTarjeta == null) {

            throw new IllegalArgumentException(TipoTarjetaConstant.INVALID_ID);

        }

        return tipoTarjetaMapper.toDto(tipoTarjeta);

    }

}
