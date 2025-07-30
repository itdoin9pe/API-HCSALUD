package com.saludsystem.submodules.principal.service.estudio;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.dtos.get.EstudioDTO;
import com.saludsystem.submodules.principal.port.dao.EstudioDao;

import java.util.UUID;

public class EstudioByIdService {

    private final EstudioDao estudioDao;

    public EstudioByIdService(EstudioDao estudioDao) {
        this.estudioDao = estudioDao;
    }

    public EstudioDTO execute(UUID uuid) {
        return EstudioMapper.toDto(estudioDao.getById(uuid));
    }

}
