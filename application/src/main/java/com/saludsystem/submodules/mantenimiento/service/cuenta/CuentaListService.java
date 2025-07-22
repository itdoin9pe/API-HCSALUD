package com.saludsystem.submodules.mantenimiento.service.cuenta;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;

import java.util.List;

public class CuentaListService {

    private final CuentaDao cuentaDao;

    public CuentaListService(CuentaDao cuentaDao) {
        this.cuentaDao = cuentaDao;
    }

    public List<CuentaDTO> execute() {
        return cuentaDao.getList()
                .stream()
                .map(CuentaMapper::toDto)
                .toList();
    }
}
