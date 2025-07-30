package com.saludsystem.submodules.principal.service.pais;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.dtos.get.PaisDTO;
import com.saludsystem.submodules.principal.port.dao.PaisDao;

public class PaisByIdService {

    private final PaisDao paisDao;

    public PaisByIdService(PaisDao paisDao) {
        this.paisDao = paisDao;
    }

    public PaisDTO execute(Integer id) {
        return PaisMapper.toDto(paisDao.getById(id));
    }

}
