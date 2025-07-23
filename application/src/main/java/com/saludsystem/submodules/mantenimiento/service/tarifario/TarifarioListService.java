package com.saludsystem.submodules.mantenimiento.service.tarifario;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;

import java.util.List;

public class TarifarioListService {

    private final TarifarioDao tarifarioDao;

    public TarifarioListService(TarifarioDao tarifarioDao) {
        this.tarifarioDao = tarifarioDao;
    }

    public List<TarifarioDTO> execute() {
        return tarifarioDao.getList()
                .stream()
                .map(TarifarioMapper::toDto)
                .toList();
    }
}
