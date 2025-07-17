package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadByIdHandler {
    private final EspecialidadDao especialidadDao;

    public EspecialidadByIdHandler(EspecialidadDao especialidadDao) {
        this.especialidadDao = especialidadDao;
    }

    public EspecialidadDTO execute(UUID uuid) {
        Especialidad model = especialidadDao.getById(uuid);
        return EspecialidadMapper.toDto(model);
    }
}