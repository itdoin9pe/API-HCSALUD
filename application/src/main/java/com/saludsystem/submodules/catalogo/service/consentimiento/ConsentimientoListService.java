package com.saludsystem.submodules.catalogo.service.consentimiento;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;

import java.util.List;

public class ConsentimientoListService {

    private final ConsentimientoDao consentimientoDao;

    public ConsentimientoListService(ConsentimientoDao consentimientoDao) {
        this.consentimientoDao = consentimientoDao;
    }

    public List<ConsentimientoDTO> execute() {
        return consentimientoDao.getList().stream().
                map(ConsentimientoMapper::toDto).toList();
    }
}
