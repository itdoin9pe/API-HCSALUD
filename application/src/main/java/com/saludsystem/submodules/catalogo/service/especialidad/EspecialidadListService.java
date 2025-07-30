package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.dto.EspecialidadCreateCommand;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;

import java.util.List;

public class EspecialidadListService {

    private final EspecialidadDao especialidadDao;

    public EspecialidadListService(EspecialidadDao especialidadDao) {
        this.especialidadDao = especialidadDao;
    }

    public List<EspecialidadCreateCommand> execute() {
        return especialidadDao.getList().stream().map(EspecialidadMapper::toDto).toList();
    }
}
