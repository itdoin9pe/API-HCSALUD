package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearConsentimientoDTO;
import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import org.springframework.stereotype.Component;

@Component
public class ConsentimientoCreateHandler {

    private final ConsentimientoDao consentimientoDao;

    public ConsentimientoCreateHandler(ConsentimientoDao consentimientoDao) {
        this.consentimientoDao = consentimientoDao;
    }

    public void execute(CrearConsentimientoDTO dto){
        consentimientoDao.save(ConsentimientoMapper.fromCreateDto(dto));
    }
}
