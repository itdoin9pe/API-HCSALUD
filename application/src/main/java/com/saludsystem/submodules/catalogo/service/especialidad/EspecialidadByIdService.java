package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;

import java.util.UUID;

public class EspecialidadByIdService {

    private final EspecialidadDao especialidadDao;

    public EspecialidadByIdService(EspecialidadDao especialidadDao) {
        this.especialidadDao = especialidadDao;
    }

    public EspecialidadDTO execute(UUID uuid) {
        return EspecialidadMapper.toDto(especialidadDao.getById(uuid));
    }
}
