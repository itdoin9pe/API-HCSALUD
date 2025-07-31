package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.constant.EspecialidadConstant;
import com.saludsystem.submodules.catalogo.model.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadByIdHandler {

    private final EspecialidadDao especialidadDao;
    private final EspecialidadMapper especialidadMapper;

    public EspecialidadByIdHandler(EspecialidadDao especialidadDao, EspecialidadMapper especialidadMapper) {
        this.especialidadDao = especialidadDao;
        this.especialidadMapper = especialidadMapper;
    }

    public EspecialidadDTO execute(UUID uuid) {

        var especialidad = especialidadDao.getById(uuid);

        if (especialidad == null) {

            throw new IllegalArgumentException(EspecialidadConstant.ID_NOT_FOUND);

        }

        return especialidadMapper.toDto(especialidad);

    }

}