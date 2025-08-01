package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.model.constant.CuentaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CuentaByIdHandler {

    private final CuentaDao cuentaDao;
    private final CuentaMapper cuentaMapper;

    public CuentaByIdHandler(CuentaDao cuentaDao, CuentaMapper cuentaMapper) {
        this.cuentaDao = cuentaDao;
        this.cuentaMapper = cuentaMapper;
    }

    public CuentaDTO execute(UUID uuid) {

        var cuenta = cuentaDao.getById(uuid);

        if (cuenta == null) {

            throw new IllegalStateException(CuentaConstant.INVALID_ID);

        }

        return cuentaMapper.toDto(cuenta);

    }

}
