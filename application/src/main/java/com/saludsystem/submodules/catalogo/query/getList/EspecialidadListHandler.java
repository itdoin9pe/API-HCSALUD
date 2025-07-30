package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EspecialidadListHandler {
    private final EspecialidadDao especialidadDao;

    public EspecialidadListHandler(EspecialidadDao especialidadDao) {
        this.especialidadDao = especialidadDao;
    }

    public List<EspecialidadDTO> execute() {
        return especialidadDao.getList().stream().map(EspecialidadMapper::toDto).toList();
    }
}
