package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.model.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EspecialidadListHandler {

    private final EspecialidadDao especialidadDao;
    private final EspecialidadMapper especialidadMapper;

    public EspecialidadListHandler(EspecialidadDao especialidadDao, EspecialidadMapper especialidadMapper) {
        this.especialidadDao = especialidadDao;
        this.especialidadMapper = especialidadMapper;
    }

    public List<EspecialidadDTO> execute() {

        List<Especialidad> especialidadList = especialidadDao.getList();

        return especialidadList.stream()
                .map(especialidadMapper::toDto)
                .toList();

    }

}
