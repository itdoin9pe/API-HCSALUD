package com.saludsystem.submodules.mantenimiento.service.cuenta;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;

import java.util.UUID;

public class CuentaByIdService {

    public final CuentaDao cuentaDao;

    public CuentaByIdService(CuentaDao cuentaDao) {
        this.cuentaDao = cuentaDao;
    }

    public CuentaDTO execute(UUID uuid) {
        return CuentaMapper.toDto(cuentaDao.getById(uuid));
    }

}
