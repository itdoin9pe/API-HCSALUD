package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoByIdHandler {

    private final ConsentimientoDao consentimientoDao;

    public ConsentimientoByIdHandler(ConsentimientoDao consentimientoDao) {
        this.consentimientoDao = consentimientoDao;
    }

    public ConsentimientoDTO execute(UUID uuid) {
        Consentimiento model = consentimientoDao.getById(uuid);
        return ConsentimientoMapper.toDto(model);
    }
}