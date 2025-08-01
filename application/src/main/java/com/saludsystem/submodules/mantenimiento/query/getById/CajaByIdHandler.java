package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.model.constant.CajaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.CajaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CajaByIdHandler {

    private final CajaDao cajaDao;
    private final CajaMapper cajaMapper;

    public CajaByIdHandler(CajaDao cajaDao, CajaMapper cajaMapper) {
        this.cajaDao = cajaDao;
        this.cajaMapper = cajaMapper;
    }

    public CajaDTO execute(UUID uuid) {

        var caja = cajaDao.getById(uuid);

        if (caja == null) {

            throw new IllegalStateException(CajaConstant.INVALID_ID);

        }

        return cajaMapper.toDto(caja);

    }

}
