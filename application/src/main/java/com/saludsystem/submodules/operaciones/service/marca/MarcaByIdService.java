package com.saludsystem.submodules.operaciones.service.marca;

import com.saludsystem.submodules.operaciones.dtos.query.MarcaDTO;
import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;

import java.util.UUID;

public class MarcaByIdService {

    private final MarcaDao marcaDao;

    public MarcaByIdService(MarcaDao marcaDao) {
        this.marcaDao = marcaDao;
    }

    public MarcaDTO execute(UUID uuid) {
        return MarcaMapper.toDto(marcaDao.getById(uuid));
    }

}
