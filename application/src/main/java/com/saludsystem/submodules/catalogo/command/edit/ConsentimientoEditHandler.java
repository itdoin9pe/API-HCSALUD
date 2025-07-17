package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarConsentimientoDTO;
import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoEditHandler {

    private final ConsentimientoDao consentimientoDao;

    public ConsentimientoEditHandler(ConsentimientoDao consentimientoDao) {
        this.consentimientoDao = consentimientoDao;
    }

    public void execute(UUID uuid, ActualizarConsentimientoDTO dto) {
        consentimientoDao.update(uuid, ConsentimientoMapper.fromUpdateDto(uuid, dto));
    }
}
