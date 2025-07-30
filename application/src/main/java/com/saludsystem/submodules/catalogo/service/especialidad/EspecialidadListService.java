package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;

import java.util.List;

public class EspecialidadListService {

    private final EspecialidadDao especialidadDao;

    public EspecialidadListService(EspecialidadDao especialidadDao) {
        this.especialidadDao = especialidadDao;
    }

    public List<EspecialidadDTO> execute() {
        return especialidadDao.getList().stream().map(EspecialidadMapper::toDto).toList();
    }
}
