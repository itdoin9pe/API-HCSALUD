package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoDeleteHandler {

    private final ConsentimientoDao consentimientoDao;

    public ConsentimientoDeleteHandler(ConsentimientoDao consentimientoDao) {
        this.consentimientoDao = consentimientoDao;
    }

    public void execute(UUID uuid) {
        consentimientoDao.delete(uuid);
    }
}