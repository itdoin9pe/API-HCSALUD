package com.saludsystem.submodules.operaciones.query.getById;

import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.model.constant.MarcaConstant;
import com.saludsystem.submodules.operaciones.model.dtos.MarcaDTO;
import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MarcaByIdHandler {

    private final MarcaDao marcaDao;
    private final MarcaMapper marcaMapper;

    public MarcaByIdHandler(MarcaDao marcaDao, MarcaMapper marcaMapper) {
        this.marcaDao = marcaDao;
        this.marcaMapper = marcaMapper;
    }

    public MarcaDTO execute(UUID uuid) {

        var marca = marcaDao.getById(uuid);

        if (marca == null) {

            throw new IllegalArgumentException(MarcaConstant.INVALID_ID);

        }

        return marcaMapper.toDto(marca);

    }

}
