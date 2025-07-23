package com.saludsystem.submodules.mantenimiento.service.moneda;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;

import java.util.UUID;

public class MonedaByIdService {

    private final MonedaDao monedaDao;

    public MonedaByIdService(MonedaDao monedaDao) {
        this.monedaDao = monedaDao;
    }

    public MonedaDTO execute(UUID uuid) {
        return MonedaMapper.toDto(monedaDao.getById(uuid));
    }
}
