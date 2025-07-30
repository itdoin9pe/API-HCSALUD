package com.saludsystem.submodules.principal.service.estudio;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.dtos.get.EstudioDTO;
import com.saludsystem.submodules.principal.port.dao.EstudioDao;

import java.util.List;

public class EstudioListService {

    private final EstudioDao estudioDao;

    public EstudioListService(EstudioDao estudioDao) {
        this.estudioDao = estudioDao;
    }

    public List<EstudioDTO> execute() {
        return estudioDao.getList()
                .stream()
                .map(EstudioMapper::toDto)
                .toList();
    }

}
