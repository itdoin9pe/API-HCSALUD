package com.saludsystem.submodules.catalogo.service.alergia;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.dto.AlergiaCreateCommand;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;

import java.util.UUID;

public class AlergiaByIdService {
    private final AlergiaDao alergiaDao;

    public AlergiaByIdService(AlergiaDao alergiaDao) {
        this.alergiaDao = alergiaDao;
    }

    public AlergiaCreateCommand execute(UUID id) {
        return AlergiaMapper.toDto(alergiaDao.getById(id));
    }
}
