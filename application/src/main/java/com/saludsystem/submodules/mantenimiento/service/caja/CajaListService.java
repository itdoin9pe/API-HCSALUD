package com.saludsystem.submodules.mantenimiento.service.caja;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.CajaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;

import java.util.List;

public class CajaListService {

    private final CajaDao cajaDao;

    public CajaListService(CajaDao cajaDao) {
        this.cajaDao = cajaDao;
    }

    public List<CajaDTO> execute() {
        return cajaDao.getList()
                .stream()
                .map(CajaMapper::toDto)
                .toList();
    }
}
