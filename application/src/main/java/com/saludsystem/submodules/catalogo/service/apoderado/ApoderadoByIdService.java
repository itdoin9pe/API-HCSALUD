package com.saludsystem.submodules.catalogo.service.apoderado;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.dto.ApoderadoCreateCommand;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;

import java.util.UUID;

public class ApoderadoByIdService {

    private final ApoderadoDao apoderadoDao;

    public ApoderadoByIdService(ApoderadoDao apoderadoDao) {
        this.apoderadoDao = apoderadoDao;
    }

    public ApoderadoCreateCommand execute(UUID uuid) {
        return ApoderadoMapper.toDto(apoderadoDao.getById(uuid));
    }
}
