package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.constant.ConsentimientoConstant;
import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoByIdHandler {

    private final ConsentimientoDao consentimientoDao;
    private final ConsentimientoMapper consentimientoMapper;

    public ConsentimientoByIdHandler(ConsentimientoDao consentimientoDao, ConsentimientoMapper consentimientoMapper) {
        this.consentimientoDao = consentimientoDao;
        this.consentimientoMapper = consentimientoMapper;
    }

    public ConsentimientoDTO execute(UUID uuid) {

        var consentimiento = consentimientoDao.getById(uuid);

        if (consentimiento == null) {

            throw new IllegalArgumentException(ConsentimientoConstant.INVALID_ID);

        }

        return consentimientoMapper.toDto(consentimiento);

    }

}