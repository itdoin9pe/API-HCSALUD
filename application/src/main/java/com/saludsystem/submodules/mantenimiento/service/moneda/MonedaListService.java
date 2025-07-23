package com.saludsystem.submodules.mantenimiento.service.moneda;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;

import java.util.List;

public class MonedaListService {

    private final MonedaDao monedaDao;

    public MonedaListService(MonedaDao monedaDao) {
        this.monedaDao = monedaDao;
    }

    public List<MonedaDTO> execute() {
        return monedaDao.getList()
                .stream()
                .map(MonedaMapper::toDto)
                .toList();
    }
}
