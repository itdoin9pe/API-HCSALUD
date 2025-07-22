package com.saludsystem.submodules.mantenimiento.service.caja;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.CajaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;

import java.util.UUID;

public class CajaByIdService {

    private final CajaDao cajaDao;

    public CajaByIdService(CajaDao cajaDao) {
        this.cajaDao = cajaDao;
    }

    public CajaDTO execute(UUID uuid) {
        return CajaMapper.toDto(cajaDao.getById(uuid));
    }
}
