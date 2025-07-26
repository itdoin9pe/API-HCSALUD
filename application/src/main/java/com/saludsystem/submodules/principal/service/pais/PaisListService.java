package com.saludsystem.submodules.principal.service.pais;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.model.dtos.get.PaisDTO;
import com.saludsystem.submodules.principal.port.dao.PaisDao;

import java.util.List;

public class PaisListService {

    private final PaisDao paisDao;

    public PaisListService(PaisDao paisDao) {
        this.paisDao = paisDao;
    }

    public List<PaisDTO> execute() {
        return paisDao.getList()
                .stream()
                .map(PaisMapper::toDto)
                .toList();
    }

}
