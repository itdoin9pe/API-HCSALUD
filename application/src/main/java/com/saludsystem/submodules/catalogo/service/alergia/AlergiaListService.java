package com.saludsystem.submodules.catalogo.service.alergia;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;

import java.util.List;

public class AlergiaListService {

    private final AlergiaDao alergiaDao;

    public AlergiaListService(AlergiaDao alergiaDao) {
        this.alergiaDao = alergiaDao;
    }

    public List<AlergiaDTO> execute() {
        return alergiaDao.getList()
                .stream()
                .map(AlergiaMapper::toDto)
                .toList();
    }
}
