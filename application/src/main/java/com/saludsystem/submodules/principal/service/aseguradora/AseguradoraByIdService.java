package com.saludsystem.submodules.principal.service.aseguradora;

import com.saludsystem.submodules.principal.model.dtos.get.AseguradoraDTO;
import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;

import java.util.UUID;

public class AseguradoraByIdService {

    private final AseguradoraDao aseguradoraDao;

    public AseguradoraByIdService(AseguradoraDao aseguradoraDao) {
        this.aseguradoraDao = aseguradoraDao;
    }

    public AseguradoraDTO execute(UUID uuid) {
        return AseguradoraMapper.toDto(aseguradoraDao.getById(uuid));
    }

}
