package com.saludsystem.submodules.catalogo.service.consentimiento;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoCreateCommand;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;

import java.util.UUID;

public class ConsentimientoByIdService {

    private final ConsentimientoDao consentimientoDao;

    public ConsentimientoByIdService(ConsentimientoDao consentimientoDao) {
        this.consentimientoDao = consentimientoDao;
    }

    public ConsentimientoCreateCommand execute(UUID uuid) {
        return ConsentimientoMapper.toDto(consentimientoDao.getById(uuid));
    }

}
