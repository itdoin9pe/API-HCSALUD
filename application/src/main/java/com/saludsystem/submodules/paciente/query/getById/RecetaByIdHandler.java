package com.saludsystem.submodules.paciente.query.getById;

import com.saludsystem.submodules.paciente.mapper.RecetaMapper;
import com.saludsystem.submodules.paciente.model.constant.RecetaConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.RecetaDTO;
import com.saludsystem.submodules.paciente.port.dao.RecetaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RecetaByIdHandler {

    private final RecetaDao recetaDao;
    private final RecetaMapper recetaMapper;

    public RecetaByIdHandler(RecetaDao recetaDao, RecetaMapper recetaMapper) {
        this.recetaDao = recetaDao;
        this.recetaMapper = recetaMapper;
    }

    public RecetaDTO execute(UUID uuid) {

        var receta = recetaDao.getById(uuid);

        if (receta == null) {

            throw new IllegalArgumentException(RecetaConstant.INVALID_ID);

        }

        return recetaMapper.toDto(receta);

    }

}
