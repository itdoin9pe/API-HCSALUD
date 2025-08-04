package com.saludsystem.submodules.operaciones.query.getList;

import com.saludsystem.submodules.operaciones.mapper.UnidadMapper;
import com.saludsystem.submodules.operaciones.model.Unidad;
import com.saludsystem.submodules.operaciones.model.dtos.UnidadDTO;
import com.saludsystem.submodules.operaciones.port.dao.UnidadDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UnidadListHandler {

    private final UnidadDao unidadDao;
    private final UnidadMapper unidadMapper;

    public UnidadListHandler(UnidadDao unidadDao, UnidadMapper unidadMapper) {
        this.unidadDao = unidadDao;
        this.unidadMapper = unidadMapper;
    }

    public List<UnidadDTO> execute() {

        List<Unidad> unidadList = unidadDao.getList();

        return unidadList.stream()
                .map(unidadMapper::toDto)
                .toList();

    }

}
