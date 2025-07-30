package com.saludsystem.submodules.catalogo.service.apoderado;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;

import java.util.List;

public class ApoderadoListService {

    private final ApoderadoDao apoderadoDao;

    public ApoderadoListService(ApoderadoDao apoderadoDao) {
        this.apoderadoDao = apoderadoDao;
    }

    public List<ApoderadoDTO> execute() {
        return apoderadoDao.getList().stream().map(ApoderadoMapper::toDto).toList();
    }
}
